package Server;
 
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
 
import HelloWorld.Hello;
import HelloWorld.HelloHelper;
 
public class Server {
	public static void main(String[] args) throws ServantNotActive, WrongPolicy, InvalidName, AdapterInactive, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {
		//ָ��ORB�Ķ˿ں� -ORBInitialPort 900
		args = new String[2];
		args[0] = "-ORBInitialPort";
		args[1] = "900";
		 
		//����һ��ORBʵ��
		ORB orb = ORB.init(args, null);
		 
		//�õ�RootPOA�����ã�������POAManager���൱��������server
		org.omg.CORBA.Object obj=orb.resolve_initial_references("RootPOA");
		POA rootpoa = POAHelper.narrow(obj);
		rootpoa.the_POAManager().activate();
		 
		//����һ��HelloWorldImplʵ��
		HelloWorldImpl helloImpl = new HelloWorldImpl();
		
		//�ӷ����еõ���������ã���ע�ᵽ������
		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
		Hello href = HelloHelper.narrow(ref);
		 
		//�õ�һ�������Ƶ�������
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		
		//�������������а��������
		String name = "Hello";
		NameComponent path[] = ncRef.to_name(name);
		ncRef.rebind(path, href);
		
		//�����̷߳��񣬵ȴ��ͻ��˵���
		orb.run();
 
	}
}
