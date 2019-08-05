# JQuery Selector

▶ 특정 문서 객체를 선택

$(선택자)


▶ 선택자 종류

+ '*'		: 전체 선택자
+ tag	: tag 선택자
+ '#'		: id 선택자
+ .		: class 선택자
+ '>'		: 자손 선택자
+ 공백	: 후손 선택자

▶ 속성 선택자

+ 요소[속성=value]	: 속성의 값과 value가 동일한 문서 객체     
+ 요소[속성|=value]	: 속성의 값이 value와 동일한 문서객체    
+ 요소[속성~=value]	: 속성의 값이 value로 시작하는 문서객체     
+ 요소[속성^=값]		: 속성의 값이 value로 시작하는 문서객체     
+ 요소[속성$=값]		: 속성의 값이 value로 끝나는 문서객체       
+ 요소[속성*=값]		: 속성의 값이 value를 포함하는 문서객체     

요소[속성|=value]     
value-%     
value로 시작하고 하이픈으로 구분되는 값     
      
      
요소[속성~=value]     
value %      
value 로 시작하고 공백으로 구분되는 값  
      
요소[속성^=값]      
value%      
value 로 시작하는 값      
     
요소[속성$=값]     
%value     
value 로 끝나는 값    
       
요소[속성*=값]     
%value%    
value 를 포함하는 값   
       
JQueryEx3.html       
       
▶ 필터 선택자      
     
+ 요소:type속성값      
+ 요소:checked      
+ 요소:disabled      
+ 요소:enabled     
+ 요소:focus       
+ 요소:selected    
     
▶배열 처리     
       
+ each()       
+ $.each(배열, function(index, item) ) { })      
- each 함수의 매개변수로 배열을 전달         
- javascript 의 일반 배열 처리 가능        
+ $(선택자).each(function(index, item) { })      
- JQuery 의 배열에서 each 함수를 호출      
- JQuery 의 배열에서 each 함수를 호출하고 있으므로     
  javascript 의 일반 배열 처리 불가    
