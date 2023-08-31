ContainerDefinition containerDefinition = new ContainerDefinition()
    .withName("my-scala-container")
    .withImage("762505115635.dkr.ecr.eu-west-1.amazonaws.com/scala_sample01:latest")
    .withMemoryReservation(512)
    .withCpu(256);