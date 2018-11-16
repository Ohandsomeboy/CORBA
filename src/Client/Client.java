package Client;
 
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
 
import HelloWorld.Hello;
import HelloWorld.HelloHelper;
 
 
public class Client {
	static Hello helloWorldImpl;
	 
	static {
		System.out.println("client��ʼ����server.......");
		 
		//��ʼ��ip�Ͷ˿ںţ�-ORBInitialHost 127.0.0.1 -ORBInitialPort 900
		String args[] = new String[4];
		args[0] = "-ORBInitialHost";
		//server�˵�IP��ַ����HelloServer�ж����
		args[1] = "127.0.0.1";
		args[2] = "-ORBInitialPort";
		//server�˵Ķ˿ڣ���HelloServer�ж����
		args[3] = "900";
		 
		//����һ��ORBʵ��
		ORB orb = ORB.init(args, null);
		 
		// ��ȡ������������
		org.omg.CORBA.Object objRef = null;
		try {
		objRef = orb.resolve_initial_references("NameService");
		} catch (InvalidName e) {
			e.printStackTrace();
		}
		NamingContextExt neRef = NamingContextExtHelper.narrow(objRef);
		 
		String name = "Hello";
		try {
			
			//ͨ��ORB�õ���serverʵ�����õ�ʵ����
			helloWorldImpl = HelloHelper.narrow(neRef.resolve_str(name));
		} catch (NotFound e) {
			e.printStackTrace();
		} catch (CannotProceed e) {
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}
		 
		System.out.println("client connected server.......");
	}
	 
	public static void main(String args[]) throws Exception {
		sayHello();
	}
	 
	//����ʵ����ķ���
	public static void sayHello() {
		String str = helloWorldImpl.sayHello("Swortain");
		System.out.println(str);
	}
}
