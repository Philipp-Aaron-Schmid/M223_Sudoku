# M223 Project Documentation

## Information Gathering
### Project Overview**  
M223_Sudoku_Backend  
  
The Project provides an environement to Play a high speed version of sudoku competitively with your peers.  
The Goal of this project was to explore the Interactions between backend and frontend in the context of of Multi user problems and solutions, so that certain information is only avaliable to privilaged users 
### Technology Analysis 
  - Springboot: Springinitializr backent initializierung
  - jwt: Web token technology
  - Mysql: database services
  - Jpa: Acess to Mysql Database
  - lombok: to create boilerplate
  - Vue.js to present a mock server in a local testin environment
  - Axios Requests to send data to the backend
  - Java: 21 for the backend
  - Jsx: Frontend
  - HTML
  - CSS
  - Codium for testin puropses
  - Roles and responsibilities

### Requirements

**Functional**
- The Project must produce a product in working state
- The User authentification must Gate data based on sign in and Role.
- Data from the Database must make its was sucesfully to the frontend.
- The user must be able to Interact with the reasources grantet to them
- Multi user access has to be implemented functionally and robustly

**None-Functional**
- Must use the latest in React technology to realize the implementation of the frontend
- Must ake popular design considerationns 
- The backend has to be secure from attacks trough malicious actors.


**Constraints**
- this project had to be completed with in a tight time frame of two weeeks.
- Tecnical know how of the Texh lead is severely limited
- The Authorization Pipeline is largely given
- JPA requires very specific stylin in terms of syntax

## Planning
### Project Scope
The Project is a one man opperation and has to be completed with in 2 weeks as such expertise and time reasources are limited to less than productive time. The Project is an exploration of new technologies therfore it is not feiasaable to greate a massive applicatio from te get go.

### Milestones and Timeline

| Event | Time |
|-------|-------|
|Rough Plan Documantation | t-13d |
|Backen ORM Functional | t- 11d |
|Backend authentification | t-7d |
| Backend Rough mappings and data transfer tested | t-7d|  
| Frontend Initialization | t-7d|
| Frontend connection tests with backend |t-4d |
| Frontend Roughly implemented no design navigation | t-2d |
| Frontendend Design Implementation/Trouble  | t-1d|
| Implementing  Automated tests | t-12h |
| Documentation | TBD

#### Tools
  - Visual Studio, this entire project is written in the very helpfull editor full if extension bot the backend and frontend were being tun in favorabl environments to speed up coding and error correction
  - GitHub, Git is the central repository for this project as a central location it orovides security and redundancy as well as room for code breaking experiments beyon a quick fix.

## Decision
### Solution Design
  The Basic arhitecture of this Project is a traditional 2.5 lyer design where we have a react Fronted handling user input and presenting backend data in aan appealing lighgt.

  In the packen we have a springboot java aapplication that simulates a backend server and connects via entities to the server layser which is not directly administered even though it is sstill imperative to know the DB layout exactly as JPA errors propagate trough the code and cause many unreadable error codes.

### Technology Stack
 
 | Technology|Role| 
|----------|----------|
| JPA/Hibernate   |     |    
|  Lombok  |    | 
|  JwT  |    | 
|    |    | 
|    |    | 
|    |    | 
|    |    | 
|    |    | 

### Risk Management
  - Identified risks
  - Mitigation strategies
### Decision Log


  | Issue | Solution | Resolution |
|----------|----------|----------|
| Scope of Application is out of bounds   | Focusing on core components can save tons of time     | The scope was ligtl trimmed to avoid feature creep    |
| Some hard Bugs have been spotted in the app   | Testing and remedie measures      | Most heavy bugs have been eliminated others due to time constraints documented in toDo's  |

## Execution
**4.1 Development Process**  
This was the virst rtuly major coding project that I have taken care of by my self as such theapproach to coding was a storm of approaches, there is some semblance of organisationas I worked trough one problem after the next. But as time moved on methods changed informed about new ways to solve problems and as such the code base is a hodge poge of attempts and code stubs that are heald together by hopes  and dreams. 
  
This Project has the very lowest coding standarts avaliable what ever works was implemented as it was fornd across the web, no uniform approach was taken, continual addaption to the Technologies have challaanged initial assumptions on best practices
  - GitHub  

**4 Progress Tracking**  
Progress was measure by Partial User story completion meaning that with the guidance of the userstories we worked on one side of the application untill it could fulfill the users needs in its role. The Application was build layered from the Database upwards to at most times have a steadily progressing functional application.
### Testing

**Backend**
**Frontend**
**Manual**


## 5. Review
- **5.1 Performance Analysis**
  - Key performance indicators
  - Performance reports
- **5.2 Feedback Collection**
  - Stakeholder feedback
  - User feedback
- **5.3 Lessons Learned**
  - Successes
  - Challenges
  - Improvement areas

## 6. Clarification of Results
- **6.1 Final Reporting**
  - Project outcomes
  - Achievement of objectives
- **6.2 Documentation and Handover**
  - Final documentation
  - Training and handover materials
- **6.3 Project Closure**
  - Formal closure
  - Future recommendations

# Detail Aknowlegements
