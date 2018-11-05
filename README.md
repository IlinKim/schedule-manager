# Conference Room Reservation

## DEMO Page
[Click Here](http://13.209.88.132:8080/)

## Environment
- Spring Boot 2.1.0
- Java 1.8
- Handlebars
- Jquery.js
- Pickr.js
- Notify.js
- Spock Test Framework
- H2 Database


## Execute on IntelliJ
- Preferences > Build, Execution, Deployment > Compiler > Annotation Processors > Check 'Enable annotation processing'
- Project Structure > Project > Set Java version to '1.8'
- Execute 'ScheduleManagerApplication.java'

## Execute on Terminal
~~~
$ cd {project root}
$ ./gradlew build
$ java -jar build/libs/schedule-manager-0.0.1-SNAPSHOT.jar
~~~
## Functions
- Make Reservation
  - First way: Click 'Make Reservation' Button (needs to put all required inputs)
  - Second way: Drag & Drop on Calendar (automatically set 'start' and 'end' time)
- Manage Room
  - Click 'Manage Room' category on navigation bar
  - Put 'Room Name'
  - Select 'Room Color'
  - Click 'Save' Button
  - You can see different colors for each conference room on calendar
  
## Entity Relationship
~~~
- ReservationGroup
  - Reservation
    - ReservationCell
      - Room
      - Timeline
~~~     
- ReservationGroup: 반복하는 예약들의 집합
- Reservation: 예약. 여러 ReservationCell을 가짐
- ReservationCell: 30분 단위의 예악 cell
- Room: 컨퍼런스 룸
- TimeLine: 30분단위의 시간 집합 테이블

## 문제 해결
1. 동시성 및 중복 처리
  - 고정된 TimeLine 테이블에 30분간격의 시간데이터를 갖고 있음.
  - ReservationCell에 date, room_id, time_line_id 필드를 Unique Key로 지정 하여 동시에 동일한 room과 동일한 예약시간으로 들어온 예약을 방지함
  
2. 반복되는 Reservation에 대한 관리
  - ReservationGroup을 두어 반복 Reservation들에 대한 동일한 처리를 할 수 있도록 설계함.

   
  
  

