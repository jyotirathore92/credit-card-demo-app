package com.assessment.creditcard.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Configuration;

/**
 * Configurations to migrate newly detected flyway scripts into database
 *
 * @author Jyoti
 */

@Configuration
public class FlywayConfig {

	static class AutoMigration implements FlywayMigrationStrategy {
		@Override
		public void migrate(Flyway flyway) {
			flyway.migrate();
		}
	}
}
