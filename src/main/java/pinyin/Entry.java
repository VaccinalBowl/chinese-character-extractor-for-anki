package pinyin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Entry {

	public static Set<String> pinyin = new HashSet<String>(Arrays.asList("a", "a1", "a2", "a3", "a4", "ai1", "ai2",
			"ai3", "ai4", "an1", "an3", "an4", "ang1", "ang2", "ang4", "ao1", "ao2", "ao3", "ao4", "ba", "ba1", "ba2",
			"ba3", "ba4","ba5", "bai", "bai1", "bai2", "bai3", "bai4", "ban1", "ban3", "ban4", "bang1", "bang3", "bang4",
			"bao","bao1", "bao2", "bao3", "bao4", "bei", "bei1", "bei3", "bei4", "ben1", "ben3", "ben4", "beng1", "beng2",
			"beng3", "beng4", "bi1", "bi2", "bi3", "bi4", "bian", "bian1", "bian3", "bian4", "biao1", "biao3", "biao4",
			"bie1", "bie2", "bie3", "bie4", "bin1", "bin4", "bing1", "bing3", "bing4", "bo", "bo1", "bo2", "bo3", "bo4",
			"bu1", "bu2", "bu3", "bu4","bu5", "ca1", "ca3", "cai1", "cai2", "cai3", "cai4", "can1", "can2", "can3", "can4",
			"cang1", "cang2", "cao1", "cao2", "cao3", "cao4", "ce4", "cei4", "cen1", "cen2", "ceng1", "ceng2", "ceng4",
			"cha1", "cha2", "cha3", "cha4", "chai1", "chai2", "chai3", "chai4", "chan1", "chan2", "chan3", "chan4",
			"chang1", "chang2", "chang3", "chang4", "chao1", "chao2", "chao3", "chao4", "che1", "che3", "che4", "chen",
			"chen1", "chen2", "chen3", "chen4", "cheng1", "cheng2", "cheng3", "cheng4", "chi1", "chi2", "chi3", "chi4",
			"chong1", "chong2", "chong3", "chong4", "chou1", "chou2", "chou3", "chou4", "chu1", "chu2", "chu3", "chu4",
			"chua1", "chuai1", "chuai2", "chuai3", "chuai4", "chuan1", "chuan2", "chuan3", "chuan4", "chuang1",
			"chuang2", "chuang3", "chuang4", "chui1", "chui2", "chun1", "chun2", "chun3", "chuo1", "chuo4", "ci1",
			"ci2", "ci3", "ci4", "cong1", "cong2", "cou4", "cu2", "cu4", "cuan1", "cuan2", "cuan4", "cui1", "cui3",
			"cui4", "cun1", "cun2", "cun3", "cun4", "cuo1", "cuo2", "cuo3", "cuo4", "da", "da1", "da2", "da3", "da4",
			"dai1", "dai3", "dai4", "dan1", "dan3", "dan4", "dang1", "dang3", "dang4", "dao1", "dao2", "dao3", "dao4",
			"de", "de1", "de2", "dei1", "dei3", "den4", "deng1", "deng3", "deng4", "di1", "di2", "di3", "di4", "dia3",
			"dian1", "dian3", "dian4", "diao1", "diao3", "diao4", "die1", "die2", "ding1", "ding3", "ding4", "diu1",
			"dong1", "dong3", "dong4", "dou1", "dou3", "dou4", "du1", "du2", "du3", "du4", "duan1", "duan3", "duan4",
			"dui1", "dui4", "dun1", "dun3", "dun4", "duo1", "duo2", "duo3", "duo4", "e", "e1", "e2", "e3", "e4", "ei1",
			"ei2", "ei3", "en1", "en4", "eng1", "er2", "er3", "er4","er5", "fa", "fa1", "fa2", "fa3", "fa4", "fan1", "fan2",
			"fan3", "fan4", "fang1", "fang2", "fang3", "fang4", "fei1", "fei2", "fei3", "fei4", "fen1", "fen2", "fen3",
			"fen4", "feng1", "feng2", "feng3", "feng4", "fo2", "fou3", "fu1", "fu2", "fu3", "fu4", "ga1", "ga2", "ga3",
			"ga4", "gai1", "gai3", "gai4", "gan1", "gan3", "gan4", "gang1", "gang3", "gang4", "gao1", "gao3", "gao4",
			"ge1", "ge2", "ge3", "ge4", "gei3", "gen1", "gen2", "gen3", "gen4", "geng1", "geng3", "geng4", "gong1",
			"gong3", "gong4", "gou1", "gou3", "gou4", "gu1", "gu3", "gu4", "gua1", "gua3", "gua4", "guai1", "guai3",
			"guai4", "guan1", "guan3", "guan4", "guang1", "guang3", "guang4", "gui1", "gui3", "gui4", "gun3", "gun4",
			"guo", "guo4", "guo1", "guo2", "guo3", "guo4", "ha1", "ha2", "ha3", "ha4", "hai1", "hai2", "hai3", "hai4",
			"han1", "han2", "han3", "han4", "hang1", "hang2", "hang4", "hao1", "hao2", "hao3", "hao4", "he1", "he2",
			"he4", "hei1", "hen2", "hen3", "hen4", "heng1", "heng2", "heng4", "hm", "hng", "hong1", "hong2", "hong3",
			"hong4", "hou1", "hou2", "hou3", "hou4", "hu1", "hu2", "hu3", "hu4", "hua1", "hua2", "hua4", "huai",
			"huai2", "huai4", "huan1", "huan2", "huan3", "huan4", "huang", "huang1", "huang2", "huang3", "huang4",
			"hui1", "hui2", "hui3", "hui4", "hun1", "hun2", "hun4", "huo1", "huo2", "huo3", "huo4", "i1", "ji1", "ji2",
			"ji3", "ji4", "jia", "jia1", "jia2", "jia3", "jia4", "jian1", "jian3", "jian4", "jiang1", "jiang3",
			"jiang4", "jiao1", "jiao2", "jiao3", "jiao4", "jie", "jie1", "jie2", "jie3", "jie4", "jin1", "jin3", "jin4",
			"jing1", "jing3", "jing4", "jiong1", "jiong3", "jiu", "jiu1", "jiu3", "jiu4", "ju1", "ju2", "ju3", "ju4",
			"juan1", "juan3", "juan4", "jue1", "jue2", "jue3", "jue4", "jun1", "jun4", "ka1", "ka3", "kai1", "kai3",
			"kai4", "kan1", "kan3", "kan4", "kang1", "kang2", "kang4", "kao1", "kao3", "kao4", "ke1", "ke2", "ke3",
			"ke4", "kei1", "kekao31", "ken3", "ken4", "keng1", "kong1", "kong3", "kong4", "kou1", "kou3", "kou4", "ku1",
			"ku3", "ku4", "kua1", "kua3", "kua4", "kuai3", "kuai4", "kuan1", "kuan3", "kuang1", "kuang2", "kuang3",
			"kuang4", "kui1", "kui2", "kui3", "kui4", "kun1", "kun3", "kun4", "kuo4", "la", "la1", "la2", "la3", "la4",
			"lai", "lai2", "lai4", "lan2", "lan3", "lan4", "lang1", "lang2", "lang3", "lang4", "lao1", "lao2", "lao3",
			"lao4", "le", "le1", "le4", "lei", "lei1", "lei2", "lei3", "lei4", "leng1", "leng2", "leng3", "leng4", "li",
			"li1", "li2", "li3", "li4", "lia3", "lian2", "lian3", "lian4", "liang2", "liang3", "liang4", "liao1",
			"liao2", "liao3", "liao4", "lie", "lie1", "lie3", "lie4", "lin1", "lin2", "lin3", "lin4", "ling2", "ling3",
			"ling4", "liu1", "liu2", "liu3", "liu4", "lo", "long1", "long2", "long3", "long4", "lou", "lou1", "lou2",
			"lou3", "lou4", "lu", "lu1", "lu2", "lu3", "lu4", "luan2", "luan3", "luan4", "lun1", "lun2", "lun3", "lun4",
			"luo", "luo1", "luo2", "luo3", "luo4", "lv2", "lv3", "lv4", "lve4", "m1", "m2", "ma", "ma1", "ma2", "ma3",
			"ma4", "mai2", "mai3", "mai4", "man1", "man2", "man3", "man4", "mang1", "mang2", "mang3", "mao1", "mao2",
			"mao3", "mao4", "me", "mei2", "mei3", "mei4", "men", "men1", "men2", "men4", "meng1", "meng2", "meng3",
			"meng4", "mi1", "mi2", "mi3", "mi4", "mian2", "mian3", "mian4", "miao1", "miao2", "miao3", "miao4", "mie1",
			"mie4", "min2", "min3", "ming2", "ming3", "ming4", "miu4", "miu44", "mo1", "mo2", "mo3", "mo4", "mou1",
			"mou2", "mou3", "mu2", "mu3", "mu4", "n2", "n3", "na", "na1", "na2", "na3", "na4", "nai3", "nai4", "nan1",
			"nan2", "nan3", "nan4", "nang1", "nang2", "nang3", "nang4", "nao1", "nao2", "nao3", "nao4", "ne", "ne2",
			"ne4", "nei3", "nei4", "nen4", "neng2", "ng2", "ng3", "ni1", "ni2", "ni3", "ni4", "nian1", "nian2", "nian3",
			"nian4", "niang2", "niao3", "niao4", "nie1", "nie2", "nie4", "nin2", "ning2", "ning3", "ning4", "niu1",
			"niu2", "niu3", "niu4", "nong2", "nong4", "nou4", "nu2", "nu3", "nu4", "nuan3", "nun2", "nuo2", "nuo4",
			"nv3", "nv4", "nve4", "o1", "o2", "o3", "o4", "ong1", "ou1", "ou2", "ou3", "ou4", "pa1", "pa2", "pa4",
			"pai1", "pai2", "pai3", "pai4", "pan1", "pan2", "pan4", "pang1", "pang2", "pang3", "pang4", "pao1", "pao2",
			"pao3", "pao4", "pei1", "pei2", "pei4", "pen1", "pen2", "pen4", "peng1", "peng2", "peng3", "peng4", "pi1",
			"pi2", "pi3", "pi4", "pian1", "pian2", "pian3", "pian4", "piao1", "piao2", "piao3", "piao4", "pie1", "pie3",
			"pie4", "pin1", "pin2", "pin3", "pin4", "ping1", "ping2", "po", "po1", "po2", "po3", "po4", "pou1", "pou2",
			"pou3", "pu1", "pu2", "pu3", "pu4", "qi1", "qi2", "qi3", "qi4", "qia1", "qia2", "qia3", "qia4", "qian1",
			"qian2", "qian3", "qian4", "qiang1", "qiang2", "qiang4", "qianwa13", "qiao1", "qiao2", "qiao3", "qiao4",
			"qie1", "qie2", "qie4", "qin1", "qin2", "qin3", "qin4", "qing1", "qing2", "qing3", "qing4", "qiong2",
			"qiu1", "qiu2", "qiu3", "qu1", "qu2", "qu3", "qu4", "quan1", "quan2", "quan3", "que1", "que2", "que4",
			"qun1", "qun2", "ran2", "ran3", "rang1", "rang2", "rang3", "rang4", "rao2", "rao3", "rao4", "re3", "re4",
			"ren2", "ren3", "ren4", "reng1", "reng2", "ri4", "rong2", "rong3", "rou2", "rou4", "ru2", "ru3", "ru4",
			"rua2", "ruan2", "ruan3", "rui2", "rui3", "rui4", "run2", "run4", "ruo2", "ruo4", "sa1", "sa3", "sa4",
			"sai1", "sai4", "san1", "san3", "san4", "sang1", "sang3", "sang4", "sao1", "sao3", "sao4", "sbuo4", "se4",
			"sen1", "seng1", "sha1", "sha2", "sha3", "sha4", "shai1", "shai3", "shai4", "shan1", "shan3", "shan4",
			"shang", "shang1", "shang3", "shang4", "shao1", "shao2", "shao3", "shao4", "she1", "she2", "she3", "she4",
			"shei2", "shen1", "shen2", "shen3", "shen4", "sheng1", "sheng2", "sheng3", "sheng4", "shi", "shi1", "shi2",
			"shi3", "shi4", "shou1", "shou2", "shou3", "shou4", "shu1", "shu2", "shu3", "shu4", "shua1", "shua3",
			"shua4", "shuai1", "shuai3", "shuai4", "shuan1", "shuan4", "shuang1", "shuang3", "shui2", "shui3", "shui4",
			"shun3", "shun4", "shuo1", "shuo4", "si1", "si3", "si4","si5", "song1", "song2", "song3", "song4", "sou1", "sou3",
			"sou4", "su1", "su2", "su4", "suan1", "suan4", "sui1", "sui2", "sui3", "sui4", "sun1", "sun3", "suo1",
			"suo3", "ta1", "ta3", "ta4", "tai1", "tai2", "tai3", "tai4", "tan1", "tan2", "tan3", "tan4", "tang1",
			"tang2", "tang3", "tang4", "tao1", "tao2", "tao3", "tao4", "te", "te4", "tei1", "teng1", "teng2", "ti1",
			"ti2", "ti3", "ti4", "tian1", "tian2", "tian3", "tian4", "tiao1", "tiao2", "tiao3", "tiao4", "tie1", "tie3",
			"tie4", "ting1", "ting2", "ting3", "ting4", "tong1", "tong2", "tong3", "tong4", "tou", "tou1", "tou2",
			"tou3", "tou4", "tu1", "tu2", "tu3", "tu4", "tuan1", "tuan2", "tuan3", "tuan4", "tui1", "tui2", "tui3",
			"tui4", "tun1", "tun2", "tun3", "tun4", "tuo1", "tuo2", "tuo3", "tuo4", "u2", "uan2", "uan4", "uang2",
			"ui1", "wa", "wa1", "wa2", "wa3", "wa4", "wai1", "wai3", "wai4", "wan1", "wan2", "wan3", "wan4", "wang1",
			"wang2", "wang3", "wang4", "wei1", "wei2", "wei3", "wei4", "wen1", "wen2", "wen3", "wen4", "weng1", "weng3",
			"weng4", "wo1", "wo3", "wo4", "wu1", "wu2", "wu3", "wu4", "xi1", "xi2", "xi3", "xi4", "xia1", "xia2",
			"xia4", "xian1", "xian2", "xian3", "xian4", "xiang1", "xiang2", "xiang3", "xiang4", "xiao1", "xiao2",
			"xiao3", "xiao4","xie", "xie1", "xie2", "xie3", "xie4", "xin1", "xin2", "xin3", "xin4", "xing1", "xing2", "xing3",
			"xing4", "xiong1", "xiong2", "xiong4", "xiu1", "xiu3", "xiu4", "xu", "xu1", "xu2", "xu3", "xu4", "xuan1",
			"xuan2", "xuan3", "xuan4", "xue1", "xue2", "xue3", "xue4", "xun1", "xun2", "xun4", "ya", "ya1", "ya2",
			"ya3", "ya4", "yan1", "yan2", "yan3", "yan4", "yang1", "yang2", "yang3", "yang4", "yao1", "yao2", "yao3",
			"yao4", "ye1", "ye2", "ye3", "ye4", "yi1", "yi2", "yi3", "yi4", "yin1", "yin2", "yin3", "yin4", "ying1",
			"ying2", "ying3", "ying4", "yingmu13", "yo", "yo1", "yong1", "yong2", "yong3", "yong4", "you1", "you2",
			"you3", "you4", "yu1", "yu2", "yu3", "yu4", "yuan1", "yuan2", "yuan3", "yuan4", "yue1", "yue3", "yue4",
			"yun1", "yun2", "yun3", "yun4", "za1", "za2", "za3", "zai1", "zai3", "zai4", "zan", "zan1", "zan2", "zan3",
			"zan4", "zang1", "zang3", "zang4", "zao1", "zao2", "zao3", "zao4", "ze2", "ze4", "zei2", "zen3", "zen4",
			"zeng1", "zeng4", "zha", "zha1", "zha2", "zha3", "zha4", "zhai1", "zhai2", "zhai3", "zhai4", "zhan1",
			"zhan3", "zhan4", "zhang1", "zhang3", "zhang4", "zhao1", "zhao2", "zhao3", "zhao4", "zhe", "zhe1", "zhe2",
			"zhe3", "zhe4", "zhei4", "zhen1", "zhen3", "zhen4", "zheng1", "zheng3", "zheng4", "zhi1", "zhi2", "zhi3",
			"zhi4", "zhong1", "zhong3", "zhong4", "zhou1", "zhou2", "zhou3", "zhou4", "zhu1", "zhu2", "zhu3", "zhu4",
			"zhua1", "zhua3", "zhuai1", "zhuai3", "zhuai4", "zhuan1", "zhuan3", "zhuan4", "zhuang1", "zhuang3",
			"zhuang4", "zhui1", "zhui4", "zhun1", "zhun3", "zhuo1", "zhuo2", "zi", "zi1", "zi3", "zi4", "zong1",
			"zong3", "zong4", "zou1", "zou3", "zou4", "zu1", "zu2", "zu3", "zuan1", "zuan3", "zuan4", "zui1", "zui3",
			"zui4", "zun1", "zun3", "zun4", "zuo1", "zuo2", "zuo3", "zuo4"));

	private String headword;
	private String pron;
	private String defn;

	private HashMap<String, String> characterPinyinMapping;

	public Entry(String headword, String pron, String defn) {
		super();
		this.headword = headword;
		this.pron = pron;
		this.defn = defn;
		this.mapCharactersToPinyin();

	}

	public String getHeadword() {
		return headword;
	}

	public void setHeadword(String headword) {
		this.headword = headword;
	}

	public String getPron() {
		return pron;
	}

	public void setPron(String pron) {
		this.pron = pron;
	}

	public String getDefn() {
		return defn;
	}

	public void setDefn(String defn) {
		this.defn = defn;
	}

	

	@Override
	public String toString() {
		return "Entry [headword=" + headword + ", pron=" + pron + ", defn=" + defn + ", characterPinyinMapping="
				+ characterPinyinMapping + "]";
	}

	private void mapCharactersToPinyin() {
		this.characterPinyinMapping = new HashMap<String,String>();
		String leftOver=this.pron;
		int characters=0;
		while(!leftOver.equals("")) {
			String longestMatch = "";
			for(int i = 0; i <= leftOver.length();i++) {
				String ss = leftOver.substring(0, i);
				if (pinyin.contains(ss)) {
					longestMatch = ss;
				}
			}

			this.characterPinyinMapping.put(Character.toString(this.headword.charAt(characters)), longestMatch);
			leftOver = leftOver.substring(longestMatch.length());

			characters++;
		}
		
		
	}

	
	public void toStdOut(){
		System.out.println(this.headword+","+this.defn.replaceAll(",", ";")+","+this.pron.toLowerCase());
		if(this.headword.length()>1) {
			for(int i = 0; i < this.headword.length();i++) {
				System.out.println(this.headword.charAt(i)+",,"+this.characterPinyinMapping.get(Character.toString(this.headword.charAt(i))));;
			}
		}
	}
	
	
}
