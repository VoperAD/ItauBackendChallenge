# Itaú Unibanco - Programming Challenge

This is a great challenge for both software development and software engineering. We want to test your ability to build software with multiple different parts working together!

## 1. Introduction

Your mission, should you choose to accept it, is to create a REST API that receives Transactions and returns Statistics based on these transactions. For this challenge, the API must be created using Java or [Kotlin](https://kotlinlang.org/) and Spring Boot.

A good place to start is the [Spring Starter](https://start.spring.io/).

> **Tip:** There is no right or wrong way to solve the challenge! We will evaluate aspects such as the quality of your code, how easy it is to understand, project organization, the number and quality of tests, security concerns, and many other factors :)

## 2. Challenge Definition

For this challenge, you must **create a REST API** on [GitHub](https://github.com/) or [GitLab](https://gitlab.com/). **Read all the instructions carefully!**

### 2.1. Technical Constraints

Your project:

- **MUST** be hosted on [GitHub](https://github.com/) or [GitLab](https://gitlab.com/)
- **MUST NOT** be a fork of any other project
- **MUST** have at least one commit per endpoint (minimum of 3 commits)
    - We want to see how your project evolves over time ;)
- All commits **MUST** be made by the same user who created the project
    - We understand that some people have personal and professional accounts or a different user for studying. Be mindful of this if you are one of these people!
- **MUST** follow the exact endpoints described below
    - For example, `/transaction` is not the same as `/transacoes`
- **MUST** accept and respond with objects exactly as described below
    - For example, `dateTime` is not the same as `data-hora` or `dtTransacao`
- **MUST NOT** use any database systems (such as H2, MySQL, PostgreSQL, etc.) or caching (such as Redis, Memcached, Infinispan, etc.)
- **MUST** store all data **in memory**
- **MUST** accept and respond only with [JSON](https://www.json.org/json-en.html)

> **Attention!** For security reasons, we cannot accept projects submitted as files. You **MUST** make your project publicly accessible so that we can review it! After receiving feedback from us, feel free to make your project **private** :)

### 2.2. API Endpoints

Below are the required API endpoints and their expected functionality.

#### 2.2.1. Receive Transactions: `POST /transaction`

This endpoint receives Transactions. Each transaction consists of a `value` and a `dateTime` indicating when it occurred:

```json
{
    "value": 123.45,
    "dateTime": "2020-08-07T12:34:56.789-03:00"
}
```

The fields in the JSON above mean the following:

| Field      | Meaning                                                    | Required? |
|------------|-------------------------------------------------------------|-----------|
| `value`    | **Floating-point decimal value** of the transaction         | Yes       |
| `dateTime` | **Date/Time in ISO 8601 format** when the transaction occurred | Yes       |

> **Tip:** Spring Boot natively understands dates in ISO 8601 format. Try using an `OffsetDateTime` attribute!

The API will only accept transactions that:

1. Have the `value` and `dateTime` fields filled in
2. **MUST NOT** occur in the future
3. **MUST** have occurred at any point in the past
4. **MUST NOT** have a negative value
5. **MUST** have a value equal to or greater than `0` (zero)

Expected responses for this endpoint:

- `201 Created` with no body
    - The transaction was accepted (i.e., validated, considered valid, and recorded)
- `422 Unprocessable Entity` with no body
    - The transaction **was not** accepted for any reason (one or more acceptance criteria were not met, e.g., a transaction with a value less than `0`)
- `400 Bad Request` with no body
    - The API could not understand the client's request (e.g., an invalid JSON)

#### 2.2.2. Clear Transactions: `DELETE /transaction`

This endpoint **deletes all stored transaction data**.

Expected responses for this endpoint:

- `200 OK` with no body
    - All information was successfully deleted

#### 2.2.3. Calculate Statistics: `GET /statistics`

This endpoint should return statistics for transactions that **occurred in the last 60 seconds (1 minute)**. The statistics that must be calculated are:

```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

The fields in the JSON above mean the following:

| Field  | Meaning                                                     | Required? |
|--------|-------------------------------------------------------------|-----------|
| `count` | **Number of transactions** in the last 60 seconds          | Yes       |
| `sum`   | **Total sum of transaction values** in the last 60 seconds | Yes       |
| `avg`   | **Average transaction value** in the last 60 seconds       | Yes       |
| `min`   | **Smallest transaction value** in the last 60 seconds      | Yes       |
| `max`   | **Largest transaction value** in the last 60 seconds       | Yes       |

> **Tip:** Java 8+ has an object called `DoubleSummaryStatistics` that might help or serve as inspiration.

Expected responses for this endpoint:

- `200 OK` with statistics data
    - A JSON with the fields `count`, `sum`, `avg`, `min`, and `max`, all filled with their respective values
    - **Attention!** If there are no transactions in the last 60 seconds, consider all values as `0` (zero)

## 4. Extras

Below are some additional challenges if you want to push your knowledge to the max! None of these requirements are mandatory, but they are desirable and could set your project apart!

1. **Automated tests:** Whether unit or functional, automated tests are important and help prevent future issues. If you write automated tests, ensure their effectiveness! For example, only testing "happy paths" is not very effective.
2. **Containerization:** Can you package your application into a container? Note: It is not necessary to publish your application's container!
3. **Logging:** Does your application provide insights into its internal processes? This is useful for developers to troubleshoot potential issues.
4. **Observability:** Does your API have an endpoint for health checks?
5. **Performance:** Can you estimate how long your application takes to compute the statistics?
6. **Error Handling:** Spring Boot provides tools to improve default error handling. Can you modify the default errors to specify which errors occurred?
7. **API Documentation:** Can you document your API? There are tools and standards that can help with this!
8. **System Documentation:** Your application likely needs to be built before it runs. Can you document how a new user can build and run it?
9. **Configurations:** Can you make your application configurable in terms of the time window for statistics calculation? For example, the default is 60 seconds, but what if the user wants 120 seconds?  
