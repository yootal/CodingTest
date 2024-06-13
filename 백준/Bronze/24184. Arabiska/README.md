# [Bronze I] Arabiska - 24184 

[문제 링크](https://www.acmicpc.net/problem/24184) 

### 성능 요약

메모리: 11540 KB, 시간: 80 ms

### 분류

구현, 문자열

### 제출 일자

2024년 6월 13일 11:15:28

### 문제 설명

<p>Det är ganska känt att när man skriver text på arabiska skriver man från höger till vänster. Det är däremot mindre välkänt att man aldrig skriver ut korta vokaler.</p>

<p>Med vokaler menar vi en av bokstäverna: <em>a,e,i,o,u,y</em>. En kort vokal defineras i detta problem som en vokal som följs av två eller fler konsonanter.</p>

<p>Skriv ett program som visar hur en mening skulle se ut om den skrevs på arabiska, d.v.s från höger till vänster och utelämnande alla korta vokaler från den ursprungliga meningen.</p>

### 입력 

 <p>Den första raden inehåller ett heltal <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container> (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c35"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>≤</mo><mi>N</mi><mo>≤</mo><mn>5</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \le N \le 5$</span></mjx-container>), antalet ord i meningen.</p>

<p>Den andra raden innehåller <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container> ord, där varje ord består av maximalt 10 gemena bokstäver från det latinska alfabetet (<code>a</code> till <code>z</code>).</p>

### 출력 

 <p>Skriv ut <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container> ord -- hur meningen skulle skrivas på arabiska.</p>

