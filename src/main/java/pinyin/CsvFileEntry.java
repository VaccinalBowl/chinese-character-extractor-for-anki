package pinyin;

import org.jsoup.Jsoup;

import java.text.Normalizer;
import java.util.*;

public class CsvFileEntry {

    private final String simplifiedCharacter;
    private final String rawPinyin;
    private String definition;
    private String pinyinSanitised;
    private String pinyinWithoutSpaces;
    private String pinyinWithoutTones;
    private boolean isSingleCharacter;
    private int numberOfCharters;
    private Set<CsvFileEntry> singleCharacterEntries;


    public static class Builder{
        private String simplifiedChinese;
        private String rawPinyin;
        private String definition;

        public Builder simplifiedChinese(String simplifiedChinese){
            this.simplifiedChinese=simplifiedChinese;
            return this;
        }

        public Builder rawPinyin(String rawPinyin){
            this.rawPinyin = rawPinyin;
            return this;
        }

        public Builder definition(String definition){
            this.definition=definition;
            return this;
        }
        public CsvFileEntry build(){
            return new CsvFileEntry(this);
        }
    }

    private CsvFileEntry(Builder builder){
        this.simplifiedCharacter=builder.simplifiedChinese;
        this.rawPinyin = builder.rawPinyin;
        this.definition = builder.definition;
        this.pinyinSanitised = Jsoup.parse(rawPinyin).text().toLowerCase();
        this.isSingleCharacter = this.simplifiedCharacter.length()==1;
        this.numberOfCharters = this.simplifiedCharacter.length();
        this.pinyinWithoutSpaces = pinyinSanitised.replaceAll(" ","");
        this.pinyinWithoutTones = Normalizer.normalize(pinyinWithoutSpaces,Normalizer.Form.NFD)
                                                    .replaceAll("\\p{M}", "");
        this.singleCharacterEntries = this.decomposeCharacterEntriesIntoList();

    }

    public String getSimplifiedCharacter() {
        return simplifiedCharacter;
    }

    public String getRawPinyin() {
        return rawPinyin;
    }

    public String getDefinition() {
        return definition;
    }

    public String getPinyinSanitised() {
        return pinyinSanitised;
    }

    public void setPinyinSanitised(String pinyinSanitised) {
        this.pinyinSanitised = pinyinSanitised;
    }

    public boolean isSingleCharacter() {
        return isSingleCharacter;
    }

    public void setSingleCharacter(boolean singleCharacter) {
        isSingleCharacter = singleCharacter;
    }

    public int getNumberOfCharters() {
        return numberOfCharters;
    }

    public void setNumberOfCharters(int numberOfCharters) {
        this.numberOfCharters = numberOfCharters;
    }

    @Override
    public String toString() {
        return "CsvFileEntry{" +
                "simplifiedCharacter='" + simplifiedCharacter + '\'' +
                ", rawPinyin='" + rawPinyin + '\'' +
                ", definition='" + definition + '\'' +
                ", pinyinSanitised='" + pinyinSanitised + '\'' +
                ", pinyinWithoutSpaces='" + pinyinWithoutSpaces + '\'' +
                ", pinyinWithoutTones='" + pinyinWithoutTones + '\'' +
                ", isSingleCharacter=" + isSingleCharacter +
                ", numberOfCharters=" + numberOfCharters +
                ", singleCharacterEntries=" + singleCharacterEntries +
                '}';
    }

    public Set<CsvFileEntry> decomposeCharacterEntriesIntoList(){
        Set<CsvFileEntry> csvFileEntry = new HashSet<>();
        if(isSingleCharacter){
            return csvFileEntry;
        }
        String tonedPinyinRemaining=pinyinWithoutSpaces;
        String untonedPinyinRemaining=pinyinWithoutTones;

        for(int i = 0 ; i < this.simplifiedCharacter.length() ; i++) {
            String characterPinyin = mapCharacterToPinyin(Character.toString(simplifiedCharacter.charAt(i)), untonedPinyinRemaining);
            String actualPinyin = tonedPinyinRemaining.substring(0,characterPinyin.length());
            tonedPinyinRemaining = tonedPinyinRemaining.substring(characterPinyin.length(),tonedPinyinRemaining.length());
            untonedPinyinRemaining = untonedPinyinRemaining.substring(characterPinyin.length(),untonedPinyinRemaining.length());

            CsvFileEntry singleCharacterFileEntry = new Builder()
                    .simplifiedChinese(Character.toString(simplifiedCharacter.charAt(i)))
                    .definition("")
                    .rawPinyin(actualPinyin)
                    .build();
            csvFileEntry.add(singleCharacterFileEntry);
        }
        return csvFileEntry;
    }

    private String mapCharacterToPinyin(String character, String pinyinString){
        String leftOverCharacters = pinyinString;
        String longestMatch = "";
        int longestMatchCurrentIndex=0;
        for(int i = 0; i <= leftOverCharacters.length();i++) {
            String currentPinyinSubstring = leftOverCharacters.substring(0, i);
            if (AnkiCsvFileProcessor.pinyinInitialsFinalsList.contains(currentPinyinSubstring)) {
                longestMatch = currentPinyinSubstring;
                longestMatchCurrentIndex=i;
            }
        }
        return longestMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CsvFileEntry that = (CsvFileEntry) o;
        return getSimplifiedCharacter().equals(that.getSimplifiedCharacter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSimplifiedCharacter());
    }

    public Set<CsvFileEntry> getSingleCharacterEntries() {
        return singleCharacterEntries;
    }

    public String toCsvLine(){
        return this.simplifiedCharacter+","+this.definition.replaceAll(",",";")+","+this.pinyinSanitised;
    }

    public CsvFileEntry mergeDefinition(CsvFileEntry otherFileEntry){
        definition = definition + "||" +otherFileEntry.getDefinition();
        return this;
    }
}
