# Fraud Detection System 🚨

A **microservices-based Fraud Detection System** built using **Spring Boot**, **Apache Kafka**, and **RabbitMQ**. This project simulates real-time transaction processing and fraud analysis, similar to systems used in banks and fintech companies.

---

## 🧩 System Architecture

```
Client
  │
  ▼
Transaction Service  ──▶ Kafka (transaction-topic)
                          │
                          ▼
                 Rule Engine Service
                          │
                          ▼
                     RabbitMQ
                          │
                          ▼
                     Alert Service
```

---

## 🛠 Tech Stack

* **Java 17**
* **Spring Boot 3.x**
* **Apache Kafka** (Event Streaming)
* **RabbitMQ** (Message Queue)
* **Docker** (Kafka, Zookeeper, RabbitMQ)
* **Maven (Multi-module project)**

---

## 📦 Project Modules

### 1️⃣ common-dto

Shared DTOs used across all services.

* `TransactionEvent`
* `FraudAlertEvent`

---

### 2️⃣ transaction-service

**Responsibility:**

* Accept transactions via REST API
* Publish transaction events to Kafka

**Key Components:**

* `TransactionController`
* `TransactionProducer`
* Kafka Producer Configuration

**API Example:**

```http
POST /api/transactions
```

---

### 3️⃣ rule-engine-service

**Responsibility:**

* Consume transactions from Kafka
* Apply fraud detection rules
* Publish fraud alerts to RabbitMQ

**Key Components:**

* `TransactionConsumer`
* `FraudRuleService`
* `FraudAlertProducer`

**Sample Rule:**

* If transaction amount > threshold → mark as fraud

---

### 4️⃣ alert-service

**Responsibility:**

* Consume fraud alerts from RabbitMQ
* Log / notify fraud alerts

**Key Components:**

* `FraudAlertConsumer`
* RabbitMQ Configuration

---

## ⚙️ How to Run the Project

### Step 1: Start Infrastructure

```bash
docker run -d -p 2181:2181 --name zookeeper confluentinc/cp-zookeeper:6.2.1
docker run -d -p 9092:9092 --name kafka --link zookeeper confluentinc/cp-kafka:6.2.1
docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:3-management
```

### Step 2: Create Kafka Topic

```bash
docker exec -it kafka kafka-topics --bootstrap-server localhost:9092 \
--create --topic transaction-topic --partitions 1 --replication-factor 1
```

### Step 3: Run Services (order)

1. transaction-service
2. rule-engine-service
3. alert-service

---

## 🧪 Testing the Flow

1. Send transaction via Postman
2. Transaction is published to Kafka
3. Rule Engine evaluates fraud
4. Fraud alert sent to RabbitMQ
5. Alert Service consumes alert

---

## ✅ Current Status

* ✔ Kafka integration working
* ✔ RabbitMQ integration working
* ✔ Services communicating successfully

---

## 🔐 Future Enhancements

* Spring Security + JWT Authentication
* Docker Compose setup
* Database integration (PostgreSQL)
* Centralized logging & monitoring

---

## 👩‍💻 Author

**Pooja Dixit**
Java | Spring Boot | Microservices

---

⭐ If you like this project, give it a star!
