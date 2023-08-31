AmazonECS client = AmazonECSClientBuilder.standard().build();
CreateServiceRequest request = new CreateServiceRequest().withServiceName("ecs-simple-service").withTaskDefinition("hello_world").withDesiredCount(10);
CreateServiceResult response = client.createService(request);AmazonECS client = AmazonECSClientBuilder.standard().build();
CreateServiceRequest request = new CreateServiceRequest()
        .withServiceName("ecs-simple-service-elb")
        .withTaskDefinition("console-sample-app-static");
       
CreateServiceResult response = client.createService(request);