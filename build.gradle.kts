plugins {
	kotlin("jvm") version "2.3.20"
	kotlin("plugin.spring") version "2.3.20"
	kotlin("plugin.jpa") version "2.3.20"

	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.openapi.generator") version "7.12.0"
}

group = "com.tuanhuydev"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")


	// Open API Generator
	implementation("io.swagger.core.v3:swagger-annotations:2.2.28")
	implementation("jakarta.validation:jakarta.validation-api:3.1.1")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.6")
	implementation("jakarta.servlet:jakarta.servlet-api:6.1.0")

	// Database
	runtimeOnly("org.postgresql:postgresql")
	testRuntimeOnly("com.h2database:h2")

}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

// Auto generate based on spec
openApiGenerate {
	generatorName.set("kotlin-spring")
	inputSpec.set("$rootDir/docs/taskbolt_spec.yml")
	outputDir.set(layout.buildDirectory.dir("generated").get().asFile.path)

	apiPackage.set("com.tuanhuydev.taskbolt.generated.api")
	modelPackage.set("com.tuanhuydev.model.generated.model")
	configOptions.set(
		mapOf(
			"dateLibrary" to "java21",
			"interfaceOnly" to "true",
			"useTags" to "true",
			"openApiNullable" to "true",
			"useSpringBoot3" to "true"
		)
	)
}

sourceSets {
	main {
		kotlin {
			srcDirs(layout.buildDirectory.dir("generated/src/main/kotlin"))
		}
	}
}


// Make sure the generated code is compiled before running tests
tasks.compileKotlin {
	dependsOn(tasks.getByName("openApiGenerate"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jar {
	enabled = false
}
