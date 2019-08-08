package com.tracktopell.learning;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Using Apache Camel
 *
 */
public class CopyFilesByCamelPathMultipleRoutes {
    public static void main( String[] args ) {
        System.out.println( "Hello ApacheCamel:" );
        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input")
                            .log("Received message is ${body} with headers: ${headers}")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output")
                            .to("file:data/output2");

                    from("file:data/input2?noop=true")
                            .to("file:data/output3")
                            .to("file:data/output4");

                }
            });
            System.out.println( "camelContext has added routes, ...now starting" );
            camelContext.start();
            System.out.println( "camelContext has added started, ...sleeping" );
            Thread.sleep(5000L);
            System.out.println( "camelContext has sleep 5 s, ...stopping " );
            camelContext.stop();
            System.out.println( "camelContext has stopped, done." );
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
