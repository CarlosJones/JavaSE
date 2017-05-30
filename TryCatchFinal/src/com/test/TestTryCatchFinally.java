package com.test;

/**
 * @author CarlosJones catch 体里遇到 return 是怎么处理？ finally 体遇到 return 怎么办？
 *         finally体里有 System.exit() 方法怎么处理？ 当 catch 和 finally 体里同时遇上 return 怎么办？
 */
public class TestTryCatchFinally {
	public static void main(String[] args) {
		TestTryCatchFinally test = new TestTryCatchFinally();
		System.out.println(test.testFinallyExit());
	}

	/**
	 * 不抛 Exception，当 finally 代码块里面遇上 System.exit() 方法 将结束和终止整个程序，而不只是方法
	 */
	public boolean testFinallyExit() {
		try {
			int i = 10 / 2; // 不抛出 Exception
			System.out.println("i vaule is : " + i);
			return true; // 获得被执行的机会，但由于 finally 已经终止程序，返回值没有机会被返回
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return true;
		} finally {
			finallyMethod();
			System.exit(0);// finally 中含有 System.exit() 语句，System.exit()
							// 将退出整个程序，程序将被终止
		}
	}

	/**
	 * 抛出 Exception，没有 finally，当 catch 遇上 return
	 */
	public boolean testCatch() {
		try {
			int i = 10 / 0; // 抛出 Exception，后续处理被拒绝
			System.out.println("i vaule is : " + i);
			return true; // Exception 已经抛出，没有获得被执行的机会
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return catchMethod(); // Exception 抛出，获得了调用方法并返回方法值的机会
		}
	}

	/**
	 * 抛出 Exception，当 catch 体里有 return，finally里面没有return,finally体的代码块将在 catch 执行
	 * return 之前被执行 若finally里面有return,则直接返回。
	 */
	@SuppressWarnings("finally")
	public boolean testCatchFinally() {
		try {
			int i = 10 / 0; // 抛出 Exception，后续处理被拒绝
			System.out.println("i vaule is : " + i);
			return true; // Exception 已经抛出，没有获得被执行的机会
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return catchMethod(); // Exception 抛出，获得了调用方法的机会，但方法值在 finally
									// 执行完后才返回
		} finally {
			finallyMethod(); // Exception 抛出，finally 代码块将在 catch 执行 return 之前被执行
			return true;
		}
	}

	/**
	 * 不抛 Exception，当 finally 代码块里面遇上 return，finally 执行完后将结束整个方法
	 * 若finally代码块里面没有return,finally执行完成以后，将返回try里面的return
	 */
	public boolean testCatchFinally2() {
		try {
			int i = 10 / 2; // 不抛出 Exception
			System.out.println("i vaule is : " + i);
			return true; // 获得被执行的机会，但执行需要在 finally 执行完成之后才能被执行
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return catchMethod();
		} finally {
			finallyMethod();
			// return false; // finally 中含有 return 语句，这个 return
			// 将结束这个方法，不会在执行完之后再跳回
			// try 或 catch 继续执行，方法到此结束，返回 false
		}
	}

	// catch 后续处理工作
	public static boolean catchMethod() {
		System.out.print("call catchMethod and return  --->>  ");
		return false;
	}

	// finally后续处理工作
	public static void finallyMethod() {
		System.out.println();
		System.out.print("call finallyMethod and do something  --->>  ");
	}
}

//java 的异常处理中，
//在不抛出异常的情况下，程序执行完 try 里面的代码块之后，该方法并不会立即结束，而是继续试图去寻找该方法有没有 finally 的代码块，
//如果没有 finally 代码块，整个方法在执行完 try 代码块后返回相应的值来结束整个方法；
//如果有 finally 代码块，此时程序执行到 try 代码块里的 return 语句之时并不会立即执行 return，而是先去执行 finally 代码块里的代码，
//若 finally 代码块里没有 return 或没有能够终止程序的代码，程序将在执行完 finally 代码块代码之后再返回 try 代码块执行 return 语句来结束整个方法；
//若 finally 代码块里有 return 或含有能够终止程序的代码，方法将在执行完 finally 之后被结束，不再跳回 try 代码块执行 return。
//在抛出异常的情况下，原理也是和上面的一样的，你把上面说到的 try 换成 catch 去理解就 OK 了