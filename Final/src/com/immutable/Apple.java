package com.immutable;
/**
 * @author CarlosJones
 * 让final变量与外界充分隔离开
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
 * 这个例子尽显封装的威力，反而与是否是final的对象无关。
 * @author CarlosJones
 *
 */
public class Apple {
	private final AppleTag appleTag;
	/**
	 * 让final变量与外界充分隔离开
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
