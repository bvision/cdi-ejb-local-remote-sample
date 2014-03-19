cdi-ejb-local-remote-sample
===========================

Sample with 2 java 2ee applications interaction throu @local and @remote ejbs with CDI


Running the sample applications:

cdi-ejb-local-remote-sample % mvn clean package

You will get two ear files: ejbtest.ear, and ejbtest2.ear, the last step is to copy them into $JBOSS_HOME/standalone/deployments.

Finally, open a browser and go to:

http://localhost:8080/ejbtest

Every request there will call the remote ejbs of the second application. See jboss server logs.

http://localhost:8080/ejbtest2

Every request there will call the remote ejbs of the first application. See jboss server logs.
