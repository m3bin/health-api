/*
 * package cloud.tus.ie.healthapi.config; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.boot.actuate.metrics.MetricsEndpoint;
 * 
 * @Configuration public class MetricsConfig {
 * 
 * 
 * @Bean public MetricsEndpoint metricsEndpoint() { BufferingMeterRegistry
 * registry = new BufferingMeterRegistry(new CachingMeterRegistry());
 * MetricsEndpointSupport metricsEndpoint = new
 * MetricsEndpointSupport(registry); return metricsEndpoint; } }
 */