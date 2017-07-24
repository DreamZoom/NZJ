package org.tool;

import java.io.FileOutputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;

public class GenerateImage {
	 //base64字符串转化成图片  
	//imageStr:图片转码的数据
	//图片保存路径
	/**
	 * 1.BASE64转为图片格式
	 * @param imgStr
	 * @param imagePath
	 * @return
	 */
    public static boolean GenerateImage(String imgStr, String imagePath)  
    {   //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成图片  
            OutputStream out = new FileOutputStream(imagePath);//新生成的图片       
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e)   
        {  
            return false;  
        }  
    }  
}
