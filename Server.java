
import java.util.concurrent.Executors;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import java.net.URI;
import com.sun.net.httpserver.HttpServer;

public class Server
{
	static ResourceConfig 	mResourceConfig 	= null;
	static HttpServer		mHttpServer			= null;
	static URI				strEndPointURI		= null;

	public static void main(String[] args)
	{
		mResourceConfig = new ResourceConfig( Resources.class );

		strEndPointURI = new URI(new StringBuilder("http://").append("127.0.0.1").append(":").append(13500).append("/").toString());

		mHttpServer = JdkHttpServerFactory.createHttpServer( strEndPointURI, mResourceConfig, false );

		mHttpServer.setExecutor( Executors.newFixedThreadPool(100) );
		mHttpServer.start();
	}
}