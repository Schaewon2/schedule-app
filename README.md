# 🗓️ 일정 관리 앱 (Schedule App)
스프링 부트(Spring Boot) 입문 과제로 제작된 일정 관리 REST API 서버입니다.

---

## API 명세서 (API Table)

### 1. 일정 추가 (Create)
- **Endpoint**: `POST /schedules`
- **Description**: 새로운 일정을 생성합니다.
- **Request Body**
- 
  | 필드명      | 타입     | 설명      | 필수 여부 |
  |:---------|:-------|:--------|:------|
  | title    | String | 일정 제목   | 필수    |
  | content  | String | 일정 내용   | 필수    |
  | name     | String | 작성자명    | 필수    |
  | password | String | 일정 비밀번호 | 필수    |

- **Response Body**
- 
  | 필드명 | 타입 | 설명 |
  | :--- | :--- | :--- |
  | id | Long | 일정 고유 식별자 |
  | title | String | 일정 제목 |
  | content | String | 일정 내용 |
  | name | String | 작성자명 |
  | createdAt | LocalDateTime | 최초 생성일 |
  | modifiedAt | LocalDateTime | 최종 수정일 |

---

### 2. 전체 일정 조회 (Read All)
- **Endpoint**: `GET /schedules`
- **Description**: 등록된 모든 일정을 조회합니다. (수정일 기준 내림차순 정렬)
- **Query Parameters**
- 
  | 파라미터명 | 타입 | 설명 | 비고 |
  | :--- | :--- | :--- | :--- |
  | name | String | 작성자명 필터링 | 선택 사항 |

---

### 3. 선택 일정 조회 (Read One)
- **Endpoint**: `GET /schedules/{scheduleId}`
- **Description**: 특정 ID의 일정 상세 정보를 조회합니다.
- **Path Variable**
- 
  | 변수명 | 설명 |
  | :--- | :--- |
  | scheduleId | 조회할 일정의 고유 ID |

---

### 4. 일정 수정 (Update)
- **Endpoint**: `PUT /schedules/{scheduleId}`
- **Description**: 비밀번호 확인 후 일정의 제목과 작성자명을 수정합니다.
- **Path Variable**
- 
  | 변수명 | 설명 |
  | :--- | :--- |
  | scheduleId | 수정할 일정의 고유 ID |
- **Query Parameters**
- 
  | 파라미터명 | 타입 | 설명 |
  | :--- | :--- | :--- |
  | password | String | 해당 일정의 비밀번호 |
- **Request Body**
- 
  | 필드명 | 타입 | 설명 |
  | :--- | :--- | :--- |
  | title | String | 수정할 제목 |
  | name | String | 수정할 작성자명 |

---

### 5. 일정 삭제 (Delete)
- **Endpoint**: `DELETE /schedules/{scheduleId}`
- **Description**: 비밀번호 확인 후 특정 일정을 삭제합니다.
- **Path Variable**
- 
  | 변수명 | 설명 |
  | :--- | :--- |
  | scheduleId | 삭제할 일정의 고유 ID |
- **Query Parameters**
- 
  | 파라미터명 | 타입 | 설명 |
  | :--- | :--- | :--- |
  | password | String | 해당 일정의 비밀번호 |

---
## ERD

![ERD](https://github.com/Schaewon2/schedule-app/raw/main/img.png)

---

## 기술 스택
- **Language:** Java 17
- **Framework:** Spring Boot 3.x
- **Database:** MySQL / H2
- **ORM:** Spring Data JPA

---

## 주요 기능
- [x] **일정 생성:** 할 일, 작성자명, 비밀번호를 입력하여 일정 등록
- [x] **일정 조회:** 선택 일정 단건 조회 및 전체 일정 목록 조회 (수정일 기준 내림차순)
- [x] **필터링:** 작성자명(Query Parameter)을 통한 선택적 목록 필터링
- [x] **일정 수정:** 비밀번호 확인 후 제목 및 작성자명 수정 (Dirty Checking 활용)
- [x] **일정 삭제:** 비밀번호 확인 후 일정 삭제

---

## 🧪 API 테스트 (Postman)
| 기능 | 메서드 | URL | 파라미터             |
| :--- | :--- | :--- |:-----------------|
| 일정 생성 | POST | `/schedules` | Body (JSON)      |
| 전체 조회 | GET | `/schedules` | `name` (선택)      |
| 단건 조회 | GET | `/schedules/{id}` | -                |
| 일정 수정 | PUT | `/schedules/{id}` | `password`, Body |
| 일정 삭제 | DELETE | `/schedules/{id}` | `password`       |

---

## 💡 배운 점 및 트러블슈팅
- **JPA 연동:** 인터페이스 선언만으로 쿼리 메서드를 생성하는 방법을 익힘.
- **DTO 변환:** Entity와 DTO를 분리하여 보안과 가독성을 높임.
- **Git Conflict:** 브랜치 병합 시 발생하는 충돌 해결 및 `--allow-unrelated-histories` 사용법 습득함.