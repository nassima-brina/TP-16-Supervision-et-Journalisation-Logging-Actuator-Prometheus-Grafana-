package ma.ens.tp8monitoring.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    private final Counter requestCounter;

    public DemoService(MeterRegistry meterRegistry) {
        this.requestCounter = Counter.builder("custom.requests.count")
                .description("Nombre total de requêtes traitées par le service Demo")
                .tag("service", "demo")
                .tag("type", "process")
                .register(meterRegistry);
    }

    public String processData() {
        logger.info("Démarrage du traitement des données");

        requestCounter.increment();

        try {
            Thread.sleep(500); // Simulation de traitement
        } catch (InterruptedException e) {
            logger.error("Erreur pendant le traitement des données", e);
            Thread.currentThread().interrupt();
        }

        logger.info("Traitement terminé avec succès. Requête enregistrée dans Prometheus");
        return "Traitement effectué avec succès";
    }
}