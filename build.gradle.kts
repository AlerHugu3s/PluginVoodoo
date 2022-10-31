plugins {
    val kotlinVersion = "1.5.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.7.0"
}

group = "org.AlerHughes"
version = "1.6.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    api("net.mamoe:mirai-console-terminal:2.12.2") // 自行替换版本
    api("net.mamoe:mirai-core:2.12.2")
}