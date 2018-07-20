package org.Arquillian.JBoss;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;

@RunWith(Arquillian.class)
public class GreeterTest {

	/* @Deployment(name="greeter-jboss") @TargetsContainer("jbossas-managed")
	public static JavaArchive createDeployment1() {
	    JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
	    	.addClasses(Greeter.class, PhraseBuilder.class)
	        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	    System.out.println(jar.toString(true));
	    return jar;
	}*/
	
	 @Deployment(name="greeter-weblogic") @TargetsContainer("weblogic")
	public static JavaArchive createDeployment2() {
	    JavaArchive jar = ShrinkWrap.create(JavaArchive.class,"greeter-weblogic.jar")
	    	.addClasses(Greeter.class, PhraseBuilder.class)
	        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	    System.out.println(jar.toString(true));
	    return jar;
	}
	
	
	@Inject
	Greeter greeter;
	
    @Test
    public void should_create_greeting() {
        Assert.assertEquals("Hello, Earthling!",
            greeter.createGreeting("Earthling"));
        greeter.greet(System.out, "Earthling");
    }
}