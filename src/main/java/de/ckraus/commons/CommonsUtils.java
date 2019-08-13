package de.ckraus.commons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommonsUtils {
    private static CommonsUtils instance;


    /**
     * Constructor
     */
    private CommonsUtils() {
        super();
    }


    /**
     * getInstance
     *
     * @return
     */
    public synchronized static CommonsUtils getInstance() {
        if ( null == instance ) {
            instance = new CommonsUtils();
        }
        return instance;
    }

    /**
     * getApplicationContext
     *
     * @return <p>Creates an {@link ClassPathXmlApplicationContext} for config file
     *         {@link SpringConstants#CONFIGURATION_BEANS_XML}</p>
     */
    public ApplicationContext getApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext( SpringConstants.CONFIGURATION_BEANS_XML );

        return context;
    }

}
