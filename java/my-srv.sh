#/usr/bin/bash

mvn archetype:generate \
-DgroupId=com.mycompany.srv \
-DartifactId=my-srv \
-DarchetypeGroupId=org.apache.cxf.archetype \
-DarchetypeArtifactId=cxf-jaxrs-service \
-DinteractiveMode=false
