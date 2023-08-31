import software.amazon.awssdk.services.ecs.EcsClient;
import software.amazon.awssdk.services.ecs.EcsClientBuilder;
import software.amazon.awssdk.regions.Region;
public class AmazonECS
{
EcsClientBuilder ecsClientBuilder = EcsClient.builder();
ecsClientBuilder.region(Region.of("eu-west-1")); // Remove extra parentheses
EcsClient ecsClient = ecsClientBuilder.build();
// Define container definition
 ContainerDefinition containerDefinition = new ContainerDefinition()
    .withName("my-scala-container")
     .withImage("762505115635.dkr.ecr.eu-west-1.amazonaws.com/scala_sample01:latest")
     .withMemoryReservation(512)
     .withCpu(256);

// Create the Task Definition
RegisterTaskDefinitionRequest request = new RegisterTaskDefinitionRequest()
    .withFamily("my-scala-task")
     .withNetworkMode(NetworkMode.Awsvpc)
     .withExecutionRoleArn("arn:aws:iam::762505115635:role/ecsTaskExecutionRole")
     .withRequiresCompatibilities(Compatibility.FARGATE)
     .withContainerDefinitions(containerDefinition);

RegisterTaskDefinitionResult result = ecsClient.registerTaskDefinition(request);
// Define the cluster and subnets
 String clusterArn = "arn:aws:ecs:eu-west-1:762505115635:cluster/ecs-cluster";
 String subnet1 = "subnet-02107846e092a3245";
 String subnet2 = "subnet-0924c8e32dd336f17";
 String subnet3 = "subnet-0ebf7e7dc4289c7e6";

 List<String> subnets = Arrays.asList(subnet1, subnet2,subnet3);

// Create the task
 RunTaskRequest runTaskRequest = new RunTaskRequest()
     .withCluster(clusterArn)
     .withTaskDefinition(result.getTaskDefinition().getTaskDefinitionArn())
     .withLaunchType(LaunchType.FARGATE)
     .withNetworkConfiguration(new NetworkConfiguration()
         .withAwsvpcConfiguration(new AwsVpcConfiguration()
             .withSubnets(subnets)
             .withAssignPublicIp(AssignPublicIp.ENABLED))
    );

 RunTaskResult runTaskResult = ecsClient.runTask(runTaskRequest);
}