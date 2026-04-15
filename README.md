# 🗓️ 일정 관리 앱 (Schedule App)
스프링 부트(Spring Boot) 입문 과제로 제작된 일정 관리 REST API 서버입니다.

## 🛠️ 기술 스택
- **Language:** Java 17
- **Framework:** Spring Boot 3.x
- **Database:** MySQL / H2
- **ORM:** Spring Data JPA

## 🚀 주요 기능
- [x] **일정 생성:** 할 일, 작성자명, 비밀번호를 입력하여 일정 등록
- [x] **일정 조회:** 선택 일정 단건 조회 및 전체 일정 목록 조회 (수정일 기준 내림차순)
- [x] **필터링:** 작성자명(Query Parameter)을 통한 선택적 목록 필터링
- [x] **일정 수정:** 비밀번호 확인 후 제목 및 작성자명 수정 (Dirty Checking 활용)
- [x] **일정 삭제:** 비밀번호 확인 후 일정 삭제

## 🧪 API 테스트 (Postman)
| 기능 | 메서드 | URL | 파라미터             |
| :--- | :--- | :--- |:-----------------|
| 일정 생성 | POST | `/schedules` | Body (JSON)      |
| 전체 조회 | GET | `/schedules` | `name` (선택)      |
| 단건 조회 | GET | `/schedules/{id}` | -                |
| 일정 수정 | PUT | `/schedules/{id}` | `password`, Body |
| 일정 삭제 | DELETE | `/schedules/{id}` | `password`       |

## 💡 배운 점 및 트러블슈팅
- **JPA 연동:** 인터페이스 선언만으로 쿼리 메서드를 생성하는 방법을 익힘.
- **DTO 변환:** Entity와 DTO를 분리하여 보안과 가독성을 높임.
- **Git Conflict:** 브랜치 병합 시 발생하는 충돌 해결 및 `--allow-unrelated-histories` 사용법 습득함.