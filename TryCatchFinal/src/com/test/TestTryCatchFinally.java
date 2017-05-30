package com.test;

/**
 * @author CarlosJones catch �������� return ����ô���� finally ������ return ��ô�죿
 *         finally������ System.exit() ������ô���� �� catch �� finally ����ͬʱ���� return ��ô�죿
 */
public class TestTryCatchFinally {
	public static void main(String[] args) {
		TestTryCatchFinally test = new TestTryCatchFinally();
		System.out.println(test.testFinallyExit());
	}

	/**
	 * ���� Exception���� finally ������������� System.exit() ���� ����������ֹ�������򣬶���ֻ�Ƿ���
	 */
	public boolean testFinallyExit() {
		try {
			int i = 10 / 2; // ���׳� Exception
			System.out.println("i vaule is : " + i);
			return true; // ��ñ�ִ�еĻ��ᣬ������ finally �Ѿ���ֹ���򣬷���ֵû�л��ᱻ����
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return true;
		} finally {
			finallyMethod();
			System.exit(0);// finally �к��� System.exit() ��䣬System.exit()
							// ���˳��������򣬳��򽫱���ֹ
		}
	}

	/**
	 * �׳� Exception��û�� finally���� catch ���� return
	 */
	public boolean testCatch() {
		try {
			int i = 10 / 0; // �׳� Exception�����������ܾ�
			System.out.println("i vaule is : " + i);
			return true; // Exception �Ѿ��׳���û�л�ñ�ִ�еĻ���
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return catchMethod(); // Exception �׳�������˵��÷��������ط���ֵ�Ļ���
		}
	}

	/**
	 * �׳� Exception���� catch ������ return��finally����û��return,finally��Ĵ���齫�� catch ִ��
	 * return ֮ǰ��ִ�� ��finally������return,��ֱ�ӷ��ء�
	 */
	@SuppressWarnings("finally")
	public boolean testCatchFinally() {
		try {
			int i = 10 / 0; // �׳� Exception�����������ܾ�
			System.out.println("i vaule is : " + i);
			return true; // Exception �Ѿ��׳���û�л�ñ�ִ�еĻ���
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return catchMethod(); // Exception �׳�������˵��÷����Ļ��ᣬ������ֵ�� finally
									// ִ�����ŷ���
		} finally {
			finallyMethod(); // Exception �׳���finally ����齫�� catch ִ�� return ֮ǰ��ִ��
			return true;
		}
	}

	/**
	 * ���� Exception���� finally ������������� return��finally ִ����󽫽�����������
	 * ��finally���������û��return,finallyִ������Ժ󣬽�����try�����return
	 */
	public boolean testCatchFinally2() {
		try {
			int i = 10 / 2; // ���׳� Exception
			System.out.println("i vaule is : " + i);
			return true; // ��ñ�ִ�еĻ��ᣬ��ִ����Ҫ�� finally ִ�����֮����ܱ�ִ��
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return catchMethod();
		} finally {
			finallyMethod();
			// return false; // finally �к��� return ��䣬��� return
			// ���������������������ִ����֮��������
			// try �� catch ����ִ�У��������˽��������� false
		}
	}

	// catch ����������
	public static boolean catchMethod() {
		System.out.print("call catchMethod and return  --->>  ");
		return false;
	}

	// finally����������
	public static void finallyMethod() {
		System.out.println();
		System.out.print("call finallyMethod and do something  --->>  ");
	}
}

//java ���쳣�����У�
//�ڲ��׳��쳣������£�����ִ���� try ����Ĵ����֮�󣬸÷����������������������Ǽ�����ͼȥѰ�Ҹ÷�����û�� finally �Ĵ���飬
//���û�� finally ����飬����������ִ���� try �����󷵻���Ӧ��ֵ����������������
//����� finally ����飬��ʱ����ִ�е� try �������� return ���֮ʱ����������ִ�� return��������ȥִ�� finally �������Ĵ��룬
//�� finally �������û�� return ��û���ܹ���ֹ����Ĵ��룬������ִ���� finally ��������֮���ٷ��� try �����ִ�� return �������������������
//�� finally ��������� return �����ܹ���ֹ����Ĵ��룬��������ִ���� finally ֮�󱻽������������� try �����ִ�� return��
//���׳��쳣������£�ԭ��Ҳ�Ǻ������һ���ģ��������˵���� try ���� catch ȥ���� OK ��