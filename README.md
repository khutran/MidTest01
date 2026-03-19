# MidTest01 - School and Classroom Management API

A Spring Boot REST API for managing Schools and Classrooms, including filtering capabilities based on student counts.

## Features

- **Get All Schools**: Retrieve a list of all schools with their associated classrooms.
- **Get School by ID**: Retrieve details for a specific school.
- **Get All Classrooms**: Retrieve a flattened list of all classrooms across all schools.
- **Filter Classrooms**: Get classrooms with a student count greater than a specified number.
- **Filter Schools**: Get schools with a total student count (sum of all classrooms) greater than a specified number.
- **String Manipulation**: Reverse strings, check palindromes, remove duplicate characters, and concatenated trimmed strings.

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.x

### Running the Application

1. Open a terminal in the project root directory.
2. Run the following command:
   ```bash
   mvn spring-boot:run
   ```
3. The application will start on port `8081`.

## API Endpoints

### School & Classroom API

| Method | Endpoint | Description | Query Params |
| :--- | :--- | :--- | :--- |
| `GET` | `/schools` | Get all schools | `noNumber` (filter by total students) |
| `GET` | `/schools/{id}` | Get school by ID | |
| `GET` | `/classrooms` | Get all classrooms | `noNumber` (filter by students) |

### String API

| Method | Endpoint | Description | Query Params |
| :--- | :--- | :--- | :--- |
| `GET` | `/string/reverse` | Reverse a string | `input` |
| `GET` | `/string/palindrome` | Check if palindrome | `input` |
| `GET` | `/string/unique` | Remove duplicate chars | `input` |
| `GET` | `/string/concat` | Concat trimmed strings | `s1`, `s2` |

### Examples

- **Reverse string**: `curl "http://localhost:8081/string/reverse?input=ABC"`
- **Check palindrome**: `curl "http://localhost:8081/string/palindrome?input=aba"`
- **Remove duplicates**: `curl "http://localhost:8081/string/unique?input=bananas"`
- **Concat and trim**: `curl "http://localhost:8081/string/concat?s1=Welcome&s2=home"`

## Project Structure

- `com.example.midtest01.midtest1`: Midtest 1 implementation.
  - `model`: `School`, `Classroom`.
  - `service`: `SchoolService`.
  - `controller`: `SchoolController`.
- `com.example.midtest01.midtest2`: Midtest 2 implementation.
  - `controller`: `StringController`.
