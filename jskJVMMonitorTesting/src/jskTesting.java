// https://github.com/prometheus/client_java
// https://github.com/prometheus/client_java
// https://github.com/prometheus/client_java#instrumenting


/*
 http://localhost:8080/jskJVMMonitorTesting/metrics
 http://localhost:8080/jskJVMMonitorTesting/jskTesting
 
 */ 

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;


/** *****
 * Servlet implementation class jskTesting
 */

@WebServlet("/jskTesting")
public class jskTesting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
/* *********
	 static final Counter requests = Counter.build()
		        .name("hello_worlds_total")
		        .help("Number of hello worlds served.").register();
		    
		    static final Counter requests2 = Counter.build()
		            .name("JSK_counter01")
		            .help("This is a JSK literal.").register();
		    
		  
		

			static final Gauge jskGauge = Gauge.build()
		            .name("JSK_Gauge")
		            .help("This is a Gauge JSK field.").register();
		    
	*/	    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jskTesting() {
        super();
        // TODO Auto-generated constructor stub
    }
 
     
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		// Add metrics about CPU, JVM memory etc.
		/*
		The Java client includes collectors for garbage collection, memory pools, JMX, classloading, and thread counts.
	    These can be added individually or just use the  DefaultExports  to conveniently register them.
		 */
		DefaultExports.initialize();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("testing ....");
		
	/*	
		 requests.inc();
	      requests2.inc();
	   */   
	      Random randomGenerator = new Random();
	      int randomInt = randomGenerator.nextInt(99999);
	     /* 
	      jskGauge.set((double)randomInt);
	      System.out.println("jsk_random :"+ jskGauge.get());
	      
	      System.out.println("jsk_counter01 :"+ requests2.get());
	      */
	      Vector v = new Vector();
	  //    while (true)
	  //    {
	        byte b[] = new byte[1048576];  // 1 mb
	        v.add(b);
	        Runtime rt = Runtime.getRuntime();
	        System.out.println( "**** free memory: " + rt.freeMemory() );
	  //    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
