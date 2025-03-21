package demo.paypal.idp.config;

import com.azure.cosmos.CosmosDiagnosticsHandler;
import com.azure.cosmos.CosmosDiagnosticsThresholds;
import com.azure.cosmos.models.CosmosClientTelemetryConfig;
import com.azure.spring.data.cosmos.core.ResponseDiagnostics;
import com.azure.spring.data.cosmos.core.ResponseDiagnosticsProcessor;
import io.micrometer.common.lang.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCosmosRepositories(basePackages = "demo.paypal.idp.repository")
public class CosmosConfiguration extends AbstractCosmosConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(CosmosConfiguration.class);

    @Value("${CONFIGURATION__AZURECOSMOSDB__ENDPOINT}")
    private String endpoint;

    @Value("${CONFIGURATION__AZURECOSMOSDB__DATABASENAME}")
    private String databaseName;

    @Value("${CONFIGURATION__AZURECOSMOSDB__FIRST_PREFERRED_REGION}")
    private String firstPreferredRegion;

    @Value("${CONFIGURATION__AZURECOSMOSDB__SECOND_PREFERRED_REGION}")
    private String secondPreferredRegion;

    @Value("${CONFIGURATION__AZURECOSMOSDB__DIAGNOSTICTHRESHOLDS_POINTOPLATENCYTHRESHOLD}")
    private int pointOperationLatencyThresholdInMS;

    @Value("${CONFIGURATION__AZURECOSMOSDB__DIAGNOSTICTHRESHOLDS_NONPOINTOPLATENCYTHRESHOLD}")
    private int nonPointOperationLatencyThresholdInMS;

    @Bean
    public CosmosClientBuilder getCosmosClientBuilder() {
        // <create_client>
        DefaultAzureCredential azureTokenCredential = new DefaultAzureCredentialBuilder()
            .build();

        return new CosmosClientBuilder()
                .endpoint(endpoint)
                .credential(azureTokenCredential)
                .preferredRegions(Arrays.asList(firstPreferredRegion, secondPreferredRegion))
                .clientTelemetryConfig(
                        new CosmosClientTelemetryConfig()
                                .diagnosticsThresholds(
                                        new CosmosDiagnosticsThresholds()
                                                .setNonPointOperationLatencyThreshold(Duration.ofMillis(nonPointOperationLatencyThresholdInMS))
                                                .setPointOperationLatencyThreshold(Duration.ofMillis(pointOperationLatencyThresholdInMS))
                                )
                                .diagnosticsHandler(CosmosDiagnosticsHandler.DEFAULT_LOGGING_HANDLER));
        // </create_client>
    }

    @Override
    public CosmosConfig cosmosConfig() {
        return CosmosConfig.builder()
            .enableQueryMetrics(true)
            .responseDiagnosticsProcessor(new ResponseDiagnosticsProcessorImplementation())
            .build();
    }

    @Override
    protected String getDatabaseName() {
        return databaseName != null ? databaseName : "paypalidp";
    }

    private static class ResponseDiagnosticsProcessorImplementation implements ResponseDiagnosticsProcessor {

        @Override
        public void processResponseDiagnostics(@Nullable ResponseDiagnostics responseDiagnostics) {
            LOGGER.info("Response Diagnostics {}", responseDiagnostics);
        }
    }
}
