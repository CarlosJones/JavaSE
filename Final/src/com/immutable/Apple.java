package com.immutable;
/**
 * @author CarlosJones
 * ��final����������ָ��뿪
 */
class AppleTag{
	private float weight;  
	  private float size;  
	  public AppleTag(float weight,float size)  
	  {  
	    setWeight(weight);  
	    setSize(size);  
	  }  
	  public void setWeight(float weight)  
	  {  
	    this.weight=weight;  
	  }  
	  public float getWeight()  
	  {  
	    return weight;  
	   }  
	  public void setSize(float size)  
	  {  
	    this.size=size;  
	  }  
	  public float getSize()  
	  {  
	    return size;  
	  }  
}

/**
 * ������Ӿ��Է�װ���������������Ƿ���final�Ķ����޹ء�
 * @author CarlosJones
 *
 */
public class Apple {
	private final AppleTag appleTag;
	/**
	 * ��final����������ָ��뿪
	 * @param appleTag
	 */
	  public Apple(AppleTag appleTag)  
	  {  
	    this.appleTag=new AppleTag(appleTag.getWeight(),appleTag.getSize()); 
//		this.appleTag = appleTag;
	  }  
	  public AppleTag getAppleTag()  
	  {  
	    return new AppleTag(appleTag.getWeight(),appleTag.getSize()); 
//	    return appleTag;
	  }  
	  public void print()  
	  {  
	    System.out.println("Weight:"+String.valueOf(appleTag.getWeight())+  
	                            " Size:"+String.valueOf(appleTag.getSize()));  
	  }  
	     
	  public static void main(String[]args)  
	  {  
	    AppleTag appleTag=new AppleTag(300f,10.3f);  
	    Apple apple=new Apple(appleTag);  
	    apple.print();  
	     
	    appleTag.setWeight(13000f);  
	    apple.print();  
	     
	    AppleTag tag=apple.getAppleTag();  
	    tag.setSize(100.3f);  
	    apple.print();  
	  }  
}
