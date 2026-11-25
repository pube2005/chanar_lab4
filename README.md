# Lab04 — JUnit 5 Unit Testing

**Оюутны нэр:** П.Пүрэвдаш  
**Оюутны код:** B232270144  
**Хичээл:** Программ хангамжийн чанар  
**Лаборатори:** 04

## 1. Зорилго

JUnit 5 ашиглан нэгжийн тест боловсруулах, хэвийн болон
хязгаарын утгуудыг шалгах, буруу оролтыг илрүүлэх,
Parameterized Test болон Mutation Testing хэрэгжүүлэх.

## 2. Ашигласан технологи

- Ubuntu / WSL2
- Java 17
- Apache Maven
- JUnit Jupiter 5.10.2
- Maven Compiler Plugin 3.11.0
- Maven Surefire Plugin 3.2.5
- Git, GitHub

## 3. Төслийн бүтэц

```text
chanar_lab4/
├── pom.xml
├── .gitignore
├── README.md
├── src/
│   ├── main/java/mn/edu/must/sqat/
│   │   └── GradeCalculator.java
│   └── test/java/mn/edu/must/sqat/
│       └── GradeCalculatorTest.java
└── results/
    ├── mvn-test.txt
    └── mvn-test-mutant.txt
```

## 4. Хэрэгжүүлсэн функцүүд

### letterGrade(double score)

Оноог үсгэн дүн рүү хөрвүүлнэ.

| Оноо | Дүн |
|---|---|
| 90–100 | A |
| 80–90-аас бага | B |
| 70–80-аас бага | C |
| 60–70-аас бага | D |
| 0–60-аас бага | F |

0-ээс бага болон 100-аас их утгад
IllegalArgumentException шиднэ.

### totalScore(att, lab, quiz1, quiz2, exam)

| Үзүүлэлт | Дээд оноо |
|---|---:|
| Ирц | 10 |
| Лаборатори | 40 |
| Сорил 1 | 10 |
| Сорил 2 | 10 |
| Шалгалт | 30 |
| Нийт | 100 |

Аль нэг оноо сөрөг эсвэл зөвшөөрөгдсөн дээд
хэмжээнээс хэтэрвэл IllegalArgumentException шиднэ.

## 5. Нэгжийн тест

Бүх тестийг AAA (Arrange–Act–Assert) бүтцээр
бичиж, Монгол хэлээр @DisplayName тодорхойлсон.

| Тестийн төрөл | Метод | Гүйцэтгэл |
|---|---:|---:|
| Энгийн @Test | 10 | 10 |
| letterGrade ParameterizedTest | 1 | 13 |
| totalScore ParameterizedTest | 1 | 5 |
| Нийт | 12 | 28 |

Шалгасан үндсэн нөхцөлүүд:

- A, B, C, D, F хэвийн утгууд.
- 90, 89.99, 60, 59.99, 0, 100 хязгаарын утгууд.
- -1 болон 101 буруу оноо.
- Нийлбэр онооны хэвийн утгууд.
- Ирцийн сөрөг оноо.
- Лабораторийн дээд хэмжээнээс хэтэрсэн оноо.
- assertEquals болон assertThrows шалгалтууд.

## 6. Тест ажиллуулах

```bash
mvn clean test
```

### Бодит үр дүн

| Үзүүлэлт | Үр дүн |
|---|---:|
| Tests run | 28 |
| Passed | 28 |
| Failures | 0 |
| Errors | 0 |
| Skipped | 0 |
| Success rate | 100% |
| Build | SUCCESS |

Нотолгоо: [mvn-test.txt](results/mvn-test.txt)

## 7. Mutation Testing

Тестийн алдаа илрүүлэх чадварыг шалгахын тулд
letterGrade методын нөхцөлийг зориуд өөрчилсөн.

Зөв нөхцөл:

```java
if (score >= 90)
```

Зориуд алдаатай нөхцөл:

```java
if (score > 90)
```

90 оноо A биш B болж өөрчлөгдсөн.

| Тест | Expected | Actual |
|---|---|---|
| ninetyIsExactlyA | A | B |
| letterGradeParameterized (90) | A | B |

### Mutation туршилтын үр дүн

| Үзүүлэлт | Үр дүн |
|---|---:|
| Tests run | 28 |
| Passed | 26 |
| Failures | 2 |
| Errors | 0 |
| Skipped | 0 |
| Build | FAILURE |
| Mutation detected | YES |

Нотолгоо: [mvn-test-mutant.txt](results/mvn-test-mutant.txt)

Mutation туршилтын дараа анхны зөв нөхцөлийг
сэргээж, бүх 28 тестийг дахин амжилттай ажиллуулсан.

## 8. Дүгнэлт

JUnit 5 ашиглан нийт 12 тестийн метод боловсруулж,
28 тестийн гүйцэтгэлийг амжилттай шалгасан.
Хэвийн, хязгаарын болон буруу утгуудыг тестэд хамруулсан.
90 онооны хязгаарын тест нь харьцуулах операторын
алдааг илрүүлэхэд чухал үүрэгтэй байсан.
Mutation Testing хийхэд зориуд оруулсан алдааг
хоёр тест амжилттай илрүүлсэн.
Анхны кодыг сэргээсний дараа бүх тест амжилттай ажилласан.
Ингэснээр нэгжийн тест нь программын логикийн алдааг
илрүүлэх, чанарыг сайжруулах боломжтойг баталгаажуулсан.

## 9. AI ашиглалт

ChatGPT-ийг Maven тохиргоо, JUnit тестийн код,
Parameterized Test болон Mutation Testing боловсруулахад ашигласан.
AI-ийн санал болгосон тестүүдээр хэвийн, хязгаарын болон
буруу утгуудыг шалгасан.
Эхний Maven тохиргоонд Java compiler болон JUnit dependency-ийн
алдаа гарсан.
Эдгээр алдааг терминалын бодит гаралтад үндэслэн зассан.
AI-ийн санал болгосон кодыг Maven ашиглан ажиллуулж баталгаажуулсан.
Эцсийн үр дүнг бодит тестийн гаралтаар нотолсон.

## 10. Орчны хувилбарын мэдээлэл

### Java

```
openjdk version "17.0.21.1" 2026-11-17
OpenJDK Runtime Environment (build 17.0.21.1+2-1-24.04.1-Ubuntu)
OpenJDK 64-Bit Server VM (build 17.0.21.1+2-1-24.04.1-Ubuntu, mixed mode, sharing)
```

### Maven

```
Apache Maven 3.8.7
Maven home: /usr/share/maven
Java version: 17.0.21.1, vendor: Ubuntu, runtime: /usr/lib/jvm/java-17-openjdk-amd64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "6.6.87.2-microsoft-standard-wsl2", arch: "amd64", family: "unix"
```
