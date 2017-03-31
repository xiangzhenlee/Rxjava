package com.yushan.rxjava.utils;


import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;


import com.yushan.rxjava.R;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextUtil {

	public static Map<String,String> faceNameToDrawableId = new HashMap<String, String>();
	public static Map<String,Integer> faceNameToDrawableId1 = new HashMap<String,Integer>();
	public static Map<String,String> drawableIdToFaceName = new HashMap<String, String>();
	public static Map<String,Integer> ylNameToDrawableId = new HashMap<String, Integer>();
	public static Map<String,String> drawableIdToYlName = new HashMap<String, String>();
	public static Map<String,Integer> hlNameToDrableId = new HashMap<String, Integer>();
	

	static{

		drawableIdToFaceName.put("h000","调皮");
		drawableIdToFaceName.put("h001","呲牙");
		drawableIdToFaceName.put("h002","惊讶");
		drawableIdToFaceName.put("h003","难过");
		drawableIdToFaceName.put("h004","酷");
		drawableIdToFaceName.put("h005","冷汗");
		drawableIdToFaceName.put("h006","抓狂");
		drawableIdToFaceName.put("h007","吐");
		drawableIdToFaceName.put("h008","偷笑");
		drawableIdToFaceName.put("h009","可爱");
		drawableIdToFaceName.put("h010","白眼");
		drawableIdToFaceName.put("h011","傲慢");
		drawableIdToFaceName.put("h012","微笑");
		drawableIdToFaceName.put("h013","撇嘴");
		drawableIdToFaceName.put("h014","色");
		drawableIdToFaceName.put("h015","发呆");
		drawableIdToFaceName.put("h016","得意");
		drawableIdToFaceName.put("h017","流泪");
		drawableIdToFaceName.put("h018","害羞");
		drawableIdToFaceName.put("h019","嘘");
		drawableIdToFaceName.put("h020","困");
		
		drawableIdToFaceName.put("h021","尴尬");
		drawableIdToFaceName.put("h022","发怒");
		drawableIdToFaceName.put("h023","大哭");
		drawableIdToFaceName.put("h024","流汗");
		drawableIdToFaceName.put("h025","再见");
		drawableIdToFaceName.put("h026","敲打");
		drawableIdToFaceName.put("h027","擦汗");
		drawableIdToFaceName.put("h028","委屈");
		drawableIdToFaceName.put("h029","疑问");
		drawableIdToFaceName.put("h030","睡");
		drawableIdToFaceName.put("h031","亲亲");
		
		drawableIdToFaceName.put("h032","憨笑");
		drawableIdToFaceName.put("h033","衰");
		drawableIdToFaceName.put("h034","阴险");
		drawableIdToFaceName.put("h035","奋斗");
		drawableIdToFaceName.put("h036","右哼哼");
		drawableIdToFaceName.put("h037","拥抱");
		drawableIdToFaceName.put("h038","坏笑");
		drawableIdToFaceName.put("h039","鄙视");
		drawableIdToFaceName.put("h040","晕");
		drawableIdToFaceName.put("h041","大兵");
		drawableIdToFaceName.put("h042","可怜");
		
		drawableIdToFaceName.put("h043","饥饿");
		drawableIdToFaceName.put("h044","咒骂");
		drawableIdToFaceName.put("h045","抠鼻");
		drawableIdToFaceName.put("h046","鼓掌");
		drawableIdToFaceName.put("h047","糗大了");
		drawableIdToFaceName.put("h048","左哼哼");
		drawableIdToFaceName.put("h049","哈欠");
		drawableIdToFaceName.put("h050","快哭了");
		drawableIdToFaceName.put("h051","吓");
		drawableIdToFaceName.put("h052","闭嘴");
		drawableIdToFaceName.put("h053","惊恐");
		
		drawableIdToFaceName.put("h054","示爱");
		drawableIdToFaceName.put("h055","爱心");
		drawableIdToFaceName.put("h056","心碎");
		drawableIdToFaceName.put("h057","蛋糕");
		drawableIdToFaceName.put("h058","闪电");
		drawableIdToFaceName.put("h059","炸弹");
		drawableIdToFaceName.put("h060","刀");
		drawableIdToFaceName.put("h061","足球");
		drawableIdToFaceName.put("h062","瓢虫");
		drawableIdToFaceName.put("h063","便便");
		drawableIdToFaceName.put("h064","咖啡");
		
		drawableIdToFaceName.put("h065","饭");
		drawableIdToFaceName.put("h066","猪");
		drawableIdToFaceName.put("h067","玫瑰");
		drawableIdToFaceName.put("h068","凋谢");
		drawableIdToFaceName.put("h069","月亮");
		drawableIdToFaceName.put("h070","太阳");
		drawableIdToFaceName.put("h071","礼物");
		drawableIdToFaceName.put("h072","强");
		drawableIdToFaceName.put("h073","弱");
		drawableIdToFaceName.put("h074","握手");
		drawableIdToFaceName.put("h075","胜利");
		
		drawableIdToFaceName.put("h076","抱拳");
		drawableIdToFaceName.put("h077","勾引");
		drawableIdToFaceName.put("h078","拳头");
		drawableIdToFaceName.put("h079","差劲");
		drawableIdToFaceName.put("h080","爱你");
		drawableIdToFaceName.put("h081","NO");
		drawableIdToFaceName.put("h082","OK");
		drawableIdToFaceName.put("h083","爱情");
		drawableIdToFaceName.put("h084","飞吻");
		drawableIdToFaceName.put("h085","跳跳");
		drawableIdToFaceName.put("h086","发抖");
		
		drawableIdToFaceName.put("h087","怄火");
		drawableIdToFaceName.put("h088","转圈");
		drawableIdToFaceName.put("h089","磕头");
		drawableIdToFaceName.put("h090","回头");
		drawableIdToFaceName.put("h091","跳绳");
		drawableIdToFaceName.put("h092","挥手");
		drawableIdToFaceName.put("h093","激动");
		drawableIdToFaceName.put("h094","街舞");
		drawableIdToFaceName.put("h095","献吻");
		drawableIdToFaceName.put("h096","左太极");
		drawableIdToFaceName.put("h097","右太极");
		
		drawableIdToFaceName.put("h098","菜刀");
		drawableIdToFaceName.put("h099","西瓜");
		drawableIdToFaceName.put("h100","啤酒");
		drawableIdToFaceName.put("h101","骷髅");
		drawableIdToFaceName.put("h102","篮球");
		drawableIdToFaceName.put("h103","乒乓");
		drawableIdToFaceName.put("h104","折磨");
	}
	static{
		faceNameToDrawableId.put("cheer","干杯");
		faceNameToDrawableId.put("geili","给力");
		faceNameToDrawableId.put("tiaopi","调皮");
		faceNameToDrawableId.put("ciya","呲牙");
		faceNameToDrawableId.put("jingya","惊讶");
		faceNameToDrawableId.put("nanguo","难过");
		faceNameToDrawableId.put("ku","酷");
		faceNameToDrawableId.put("lenghan","冷汗");
		faceNameToDrawableId.put("zhuakuang","抓狂");
		faceNameToDrawableId.put("tu","吐");
		faceNameToDrawableId.put("touxiao","偷笑");
		faceNameToDrawableId.put("keai","可爱");
		faceNameToDrawableId.put("baiyan","白眼");
		faceNameToDrawableId.put("aoman","傲慢");
		faceNameToDrawableId.put("weixiao","微笑");
		faceNameToDrawableId.put("pizui","撇嘴");
		faceNameToDrawableId.put("se","色");
		faceNameToDrawableId.put("fadai","发呆");
		faceNameToDrawableId.put("deyi","得意");
		faceNameToDrawableId.put("liulei","流泪");
		faceNameToDrawableId.put("haixiu","害羞");
		faceNameToDrawableId.put("xu","嘘");
		faceNameToDrawableId.put("kun","困");
		faceNameToDrawableId.put("woshou", "握手");
		
		faceNameToDrawableId.put("ganga","尴尬");
		faceNameToDrawableId.put("fanu","发怒");
		faceNameToDrawableId.put("daku","大哭");
		faceNameToDrawableId.put("liuhan","流汗");
		faceNameToDrawableId.put("zaijian","再见");
		faceNameToDrawableId.put("qiaoda","敲打");
		faceNameToDrawableId.put("cahan","擦汗");
		faceNameToDrawableId.put("weiqu","委屈");
		faceNameToDrawableId.put("wen","疑问");
		faceNameToDrawableId.put("shuijiao","睡");
		faceNameToDrawableId.put("qinqin","亲亲");
		
		faceNameToDrawableId.put("hanxiao","憨笑");
		faceNameToDrawableId.put("shuai","衰");
		faceNameToDrawableId.put("yinxian","阴险");
		faceNameToDrawableId.put("fendou","奋斗");
		faceNameToDrawableId.put("youhengheng","右哼哼");
		faceNameToDrawableId.put("yongbao","拥抱");
		faceNameToDrawableId.put("huaixiao","坏笑");
		faceNameToDrawableId.put("bishi","鄙视");
		faceNameToDrawableId.put("yun","晕");
		faceNameToDrawableId.put("dabing","大兵");
		faceNameToDrawableId.put("kelian","可怜");
		
		faceNameToDrawableId.put("er","饥饿");
		faceNameToDrawableId.put("ma","咒骂");
		faceNameToDrawableId.put("wabi","抠鼻");
		faceNameToDrawableId.put("guzhang","鼓掌");
		faceNameToDrawableId.put("qiudale","糗大了");
		faceNameToDrawableId.put("zuohengheng","左哼哼");
		faceNameToDrawableId.put("haqian","哈欠");
		faceNameToDrawableId.put("kuaikyle","快哭了");
		faceNameToDrawableId.put("xia","吓");
		faceNameToDrawableId.put("bizui","闭嘴");
		faceNameToDrawableId.put("jingkong","惊恐");
		
		faceNameToDrawableId.put("zhemo","折磨");
		faceNameToDrawableId.put("kiss","示爱");
		faceNameToDrawableId.put("love","爱心");
		faceNameToDrawableId.put("xinsui","心碎");
		faceNameToDrawableId.put("dangao","蛋糕");
		faceNameToDrawableId.put("shandian","闪电");
		faceNameToDrawableId.put("zhadan","炸弹");
		faceNameToDrawableId.put("dao","刀");
		faceNameToDrawableId.put("zuqiu","足球");
		faceNameToDrawableId.put("chong","瓢虫");
		faceNameToDrawableId.put("dabian","便便");
		
		faceNameToDrawableId.put("kafei","咖啡");
		faceNameToDrawableId.put("fan","饭");
		faceNameToDrawableId.put("zhutou","猪");
		faceNameToDrawableId.put("hua","玫瑰");
		faceNameToDrawableId.put("diaoxie","凋谢");
		faceNameToDrawableId.put("yueliang","月亮");
		faceNameToDrawableId.put("taiyang","太阳");
		faceNameToDrawableId.put("liwu","礼物");
		faceNameToDrawableId.put("qiang","强");
		faceNameToDrawableId.put("ruo","弱");
		faceNameToDrawableId.put("wushou","握手");
		
		faceNameToDrawableId.put("shengli","胜利");
		faceNameToDrawableId.put("peifu","抱拳");
		faceNameToDrawableId.put("touyin","勾引");
		faceNameToDrawableId.put("quantou","拳头");
		faceNameToDrawableId.put("chajin","差劲");
		faceNameToDrawableId.put("no","NO");
		faceNameToDrawableId.put("ok","OK");
		faceNameToDrawableId.put("feiwen","飞吻");
		faceNameToDrawableId.put("tiao","跳跳");
		
		faceNameToDrawableId.put("fadou","发抖");
		faceNameToDrawableId.put("dajiao","怄火");
		faceNameToDrawableId.put("zhuanquan","转圈");
		faceNameToDrawableId.put("ketou","磕头");
		faceNameToDrawableId.put("huitou","回头");
		faceNameToDrawableId.put("tiaosheng","跳绳");
		faceNameToDrawableId.put("huishou","挥手");
		faceNameToDrawableId.put("jidong","激动");
		faceNameToDrawableId.put("tiaowu","街舞");
		faceNameToDrawableId.put("xianwen","献吻");
		faceNameToDrawableId.put("zuotaiji","左太极");
		
		faceNameToDrawableId.put("youtaiji","右太极");
		faceNameToDrawableId.put("caidao","菜刀");
		faceNameToDrawableId.put("xigua","西瓜");
		faceNameToDrawableId.put("pijiu","啤酒");
		faceNameToDrawableId.put("kulou","骷髅");
		faceNameToDrawableId.put("lanqiu","篮球");
		faceNameToDrawableId.put("pingpang","乒乓");
	}
	

	public static SpannableString decorateFaceInStr(SpannableString spannable, List<Map<String,Object>> list, Resources resources){
		int size = list.size();
		Drawable drawable = null;
		if(list!=null&&list.size()>0){
			for(int i=0;i<size;i++){
				Map<String,Object> map = list.get(i);
				try{
					drawable = resources.getDrawable(faceNameToDrawableId1.get(map.get("faceName")));
					drawable.setBounds(0, 0, drawable.getIntrinsicWidth()+5,drawable.getIntrinsicHeight()+5);
					ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
					spannable.setSpan(span, (Integer)map.get("startIndex"), (Integer)map.get("endIndex"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				}catch(Exception e){
					spannable.setSpan("["+map.get("faceName")+"]", (Integer)map.get("startIndex"), (Integer)map.get("endIndex"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				}
			}
		}
		return spannable;
	}


	
	public static SpannableString decorateTopicInStr(SpannableString spannable, List<Map<String,Object>> list, Resources resources){
		int size = list.size();
		Drawable drawable = null;
		CharacterStyle foregroundColorSpan=new ForegroundColorSpan(Color.argb(255, 33, 92, 110));
		if(list!=null&&list.size()>0){
			for(int i=0;i<size;i++){
				Map<String,Object> map = list.get(i);
				spannable.setSpan(foregroundColorSpan, (Integer)map.get("startIndex"), (Integer)map.get("endIndex"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
		return spannable;
	}
	
	public static SpannableString decorateRefersInStr(SpannableString spannable, List<Map<String,Object>> list, Resources resources){
		int size = list.size();
		Drawable drawable = null;
		CharacterStyle foregroundColorSpan=new ForegroundColorSpan(Color.argb(255, 33, 92, 110));
		if(list!=null&&list.size()>0){
			for(int i=0;i<size;i++){
				Map<String,Object> map = list.get(i);
				spannable.setSpan(foregroundColorSpan, (Integer)map.get("startIndex"), (Integer)map.get("endIndex"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
		return spannable;
	}
	
	public static String htmlToString (String htmlString){
		String result="";
		boolean flag = true; 
		if(htmlString==null){ 
		return null; 
		} 
		htmlString = htmlString.replace("\"", ""); //去掉引号 
		char[] a = htmlString.toCharArray(); 
		int length=a.length; 
		for(int i=0;i<length;i++){ 
			if(a[i]=='<'){ 
				flag=false; 
				continue; 
			} 
			if(a[i]=='>'){ 
				flag=true; 
				continue; 
			} 
			if(flag==true){ 
				result+=a[i]; 
			} 
		} 
		return result.toString(); 
	}
	
	public static String htmlToStringNew (String htmlString){
		if(htmlString==null){ 
		return null; 
		} 
		while(htmlString.contains("<img")){
			String sub = htmlString.substring(htmlString.indexOf("<img"), htmlString.indexOf("/>")+2);
			htmlString = htmlString.replace(sub, "");
		}
		return htmlString;
	}
	
	public static int getCharacterNum(final String content){
		if (null == content || "".equals(content)) {
			return 0;
			}else {
			return (content.length() + getChineseNum(content));
		}
	}
	
	public static int getChineseNum(String s) {
		int num = 0;
		char[] myChar = s.toCharArray();
		for (int i = 0; i < myChar.length; i++) {
			if ((char)(byte)myChar[i] != myChar[i]) {
				num++;
			}
		}
		return num;
		}
	public static String getMD5Str(String str, String type) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
//			Log.w(TAG, "NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		if (type.equals("16")) {
			// 16位加密，从第9位到25位
			return md5StrBuff.substring(8, 24).toString().toUpperCase();
		} else {
			// 32位加密
			return md5StrBuff.toString().toUpperCase();
		}
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return boolean
	 * @author: ccy Create at: 2012-4-13 上午11:17:56
	 */
	public static boolean chkStrEmpty(String str) {
		return str.equals("") || str == null || str == "" || str.length() <= 0;
	}

	/**
	 * 判断email格式
	 * 
	 * @param str
	 * @return boolean
	 * @author: ccy Create at: 2012-4-13 上午11:30:52
	 */
	public static boolean isEmail(String str) {
		Pattern p = Pattern
				.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher m = p.matcher(str);
		return m.matches();
	}
	
	/**
	 * 截取字符串
	 *
	 * @param string
	 * @param length
	 * @return
	 * @author:     ccy
	 * Create at:   2012-5-23 下午3:36:45
	 */
	public static String subString(String string, int length) {
		if(string.length() > length) {
			string = string.substring(0, length);
		}
		return string;
	}
	
	/**
	 * TextView设置属性字体
	 */
	
	public static SpannedString hintSet(String str){
		
		
		// 新建一个可以添加属性的文本对象
		SpannableString ss = new SpannableString(str);
		// 新建一个属性对象,设置文字的大小
		AbsoluteSizeSpan ass = new AbsoluteSizeSpan(16, true);
		// 附加属性到文本
		ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			
		return new SpannedString(ss);
	}
	
}
