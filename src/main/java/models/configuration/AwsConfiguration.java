package models.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AwsConfiguration {


    @JsonProperty("aws.configured")
    private boolean configured;

    @JsonProperty("aws.accessKeyId")
    private String accessKeyId;

    @JsonProperty("aws.accessKeySecret")
    private String accessKeySecret;

    @JsonProperty("aws.region")
    private String region;

    @JsonProperty("aws.allRegionEnabled")
    private boolean allRegionEnabled;

    @JsonProperty("aws.accountTag")
    private String accountTag;

    @JsonProperty("aws.roleArns")
    private String roleArns;


    @JsonProperty("aws.enableLoadBalancer")
    private boolean enableLoadBalancer;


    @JsonProperty("aws.enableNatGateways")
    private boolean enableNatGateways;

    @JsonProperty("aws.enableInternetGateways")
    private boolean enableInternetGateways;

    @JsonProperty("aws.enableS3Buckets")
    private boolean enableS3Buckets;

    @JsonProperty("aws.enableWorkspaces")
    private boolean enableWorkspaces;

    @JsonProperty("aws.enableLambdaFunctions")
    private boolean enableLambdaFunctions;

    @JsonProperty("aws.enableRoute53Assets")
    private boolean enableRoute53Assets;

    @JsonProperty("aws.enableIamUsers")
    private boolean enableIamUsers;

    @JsonProperty("aws.enableRdsInstances")
    private boolean enableRdsInstances;

    @JsonProperty("aws.enableEcsContainerInstances")
    private boolean enableEcsContainerInstances;

    @JsonProperty("aws.enableEc2AttachedIamRoles")
    private boolean enableEc2AttachedIamRoles;

    @JsonProperty("aws.discoverOnlyPoweredOnEc2Instances")
    private boolean discoverOnlyPoweredOnEc2Instances;

    @JsonProperty("aws.enableIamUsersServices")
    private boolean enableIamUsersServices;

    @JsonProperty("aws.resolveLoadBalancerIp")
    private boolean resolveLoadBalancerIp;

    @JsonProperty("aws.enableLoadBalancerTargets")
    private boolean enableLoadBalancerTargets;

    @JsonProperty("aws.correlateEcsContainerInstancesWithEc2Instances")
    private boolean correlateEcsContainerInstancesWithEc2Instances;


    @JsonProperty("aws.disableFetchingFromPrimaryAccount")
    private boolean disableFetchingFromPrimaryAccount;

    public AwsConfiguration(boolean configured, String accessKeyId, String accessKeySecret, String region, boolean allRegionEnabled, String accountTag, String roleArns, boolean enableLoadBalancer, boolean enableNatGateways, boolean enableInternetGateways, boolean enableS3Buckets, boolean enableWorkspaces, boolean enableLambdaFunctions, boolean enableRoute53Assets, boolean enableIamUsers, boolean enableRdsInstances, boolean enableEcsContainerInstances, boolean enableEc2AttachedIamRoles, boolean discoverOnlyPoweredOnEc2Instances, boolean enableIamUsersServices, boolean resolveLoadBalancerIp, boolean enableLoadBalancerTargets, boolean correlateEcsContainerInstancesWithEc2Instances, boolean disableFetchingFromPrimaryAccount) {
        this.configured = configured;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.region = region;
        this.allRegionEnabled = allRegionEnabled;
        this.accountTag = accountTag;
        this.roleArns = roleArns;
        this.enableLoadBalancer = enableLoadBalancer;
        this.enableNatGateways = enableNatGateways;
        this.enableInternetGateways = enableInternetGateways;
        this.enableS3Buckets = enableS3Buckets;
        this.enableWorkspaces = enableWorkspaces;
        this.enableLambdaFunctions = enableLambdaFunctions;
        this.enableRoute53Assets = enableRoute53Assets;
        this.enableIamUsers = enableIamUsers;
        this.enableRdsInstances = enableRdsInstances;
        this.enableEcsContainerInstances = enableEcsContainerInstances;
        this.enableEc2AttachedIamRoles = enableEc2AttachedIamRoles;
        this.discoverOnlyPoweredOnEc2Instances = discoverOnlyPoweredOnEc2Instances;
        this.enableIamUsersServices = enableIamUsersServices;
        this.resolveLoadBalancerIp = resolveLoadBalancerIp;
        this.enableLoadBalancerTargets = enableLoadBalancerTargets;
        this.correlateEcsContainerInstancesWithEc2Instances = correlateEcsContainerInstancesWithEc2Instances;
        this.disableFetchingFromPrimaryAccount = disableFetchingFromPrimaryAccount;
    }







}
