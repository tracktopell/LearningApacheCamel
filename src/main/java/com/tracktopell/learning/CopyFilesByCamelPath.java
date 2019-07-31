package com.tracktopell.learning;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Using Apache Camel
 *
 */
public class CopyFilesByCamelPath {
    public static void main( String[] args ) {
        System.out.println( "Hello ApacheCamel:" );
        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input")
                            .to("file:data/output");
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
