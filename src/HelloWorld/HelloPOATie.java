package HelloWorld;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Hello".
 *
 * @author JacORB IDL compiler V 3.3
 * @version generated at 2018-11-5 19:28:07
 */

public class HelloPOATie
	extends HelloPOA
{
	private HelloOperations _delegate;

	private POA _poa;
	public HelloPOATie(HelloOperations delegate)
	{
		_delegate = delegate;
	}
	public HelloPOATie(HelloOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public HelloWorld.Hello _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		HelloWorld.Hello __r = HelloWorld.HelloHelper.narrow(__o);
		return __r;
	}
	public HelloWorld.Hello _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		HelloWorld.Hello __r = HelloWorld.HelloHelper.narrow(__o);
		return __r;
	}
	public HelloOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(HelloOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public java.lang.String sayHello(java.lang.String name)
	{
		return _delegate.sayHello(name);
	}

}
