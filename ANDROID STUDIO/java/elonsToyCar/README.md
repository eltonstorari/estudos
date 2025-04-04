<section class="instructions-pane"><div class="c-textual-content --small"><div class="introduction"><h2><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Introdução</font></font></h2><div class="content"><h3 id="h-classes"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Aulas</font></font></h3>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">A construção primária orientada a objetos em Java é a </font></font><em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">classe</font></font></em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> , que é uma combinação de dados ( </font></font><em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">campos</font></font></em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> ) e comportamento ( </font></font><em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">métodos</font></font></em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> ). Os campos e métodos de uma classe são conhecidos como seus </font></font><em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">membros</font></font></em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> .</font></font></p>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">O acesso aos membros pode ser controlado por meio de modificadores de acesso, sendo os dois mais comuns:</font></font></p>
<ul>
<li>
<code>public</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">: o membro pode ser acessado por qualquer código (sem restrições).</font></font></li>
<li>
<code>private</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">: o membro só pode ser acessado por código na mesma classe.</font></font></li>
</ul>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Você pode pensar em uma classe como um modelo para criar instâncias dessa classe. Para criar uma instância de uma classe (também conhecida como </font></font><em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">object</font></font></em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> ), a </font></font><code>new</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">palavra-chave é usada:</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-keyword">class</span> <span class="hljs-title class_">Car</span> {<font></font>
}<font></font>
<font></font>
<span class="hljs-comment">// Create two car instances</span>
<span class="hljs-type">Car</span> <span class="hljs-variable">myCar</span> <span class="hljs-operator">=</span> <span class="hljs-keyword">new</span> <span class="hljs-title class_">Car</span>();
<span class="hljs-type">Car</span> <span class="hljs-variable">yourCar</span> <span class="hljs-operator">=</span> <span class="hljs-keyword">new</span> <span class="hljs-title class_">Car</span>();
</code></pre>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Os campos têm um tipo e um nome (definidos em camelCase) e podem ser definidos em qualquer lugar de uma classe (por convenção, em PascalCase):</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-keyword">class</span> <span class="hljs-title class_">Car</span> {
    <span class="hljs-comment">// Accessible by anyone</span>
    <span class="hljs-keyword">public</span> <span class="hljs-type">int</span> weight;<font></font>
<font></font>
    <span class="hljs-comment">// Only accessible by code in this class</span>
    <span class="hljs-keyword">private</span> String color;<font></font>
}<font></font>
</code></pre>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Opcionalmente, pode-se atribuir um valor inicial a um campo. Se um campo </font></font><em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">não</font></font></em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> especificar um valor inicial, ele será definido como o valor padrão do seu tipo. Os valores de campo de uma instância podem ser acessados ​​e atualizados usando notação de ponto.</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-keyword">class</span> <span class="hljs-title class_">Car</span> {
    <span class="hljs-comment">// Will be set to specified value</span>
    <span class="hljs-keyword">public</span> <span class="hljs-type">int</span> <span class="hljs-variable">weight</span> <span class="hljs-operator">=</span> <span class="hljs-number">2500</span>;<font></font>
<font></font>
    <span class="hljs-comment">// Will be set to default value (0)</span>
    <span class="hljs-keyword">public</span> <span class="hljs-type">int</span> year;<font></font>
}<font></font>
<font></font>
<span class="hljs-type">Car</span> <span class="hljs-variable">newCar</span> <span class="hljs-operator">=</span> <span class="hljs-keyword">new</span> <span class="hljs-title class_">Car</span>();<font></font>
newCar.weight; <span class="hljs-comment">// =&gt; 2500</span>
newCar.year;   <span class="hljs-comment">// =&gt; 0</span><font></font>
<font></font>
<span class="hljs-comment">// Update value of the field</span>
newCar.year = <span class="hljs-number">2018</span>;
</code></pre>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Campos privados geralmente são atualizados como um efeito colateral da chamada de um método. Tais métodos geralmente não retornam nenhum valor, em cujo caso o tipo de retorno deve ser </font></font><code>void</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">:</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-keyword">class</span> <span class="hljs-title class_">CarImporter</span> {
    <span class="hljs-keyword">private</span> <span class="hljs-type">int</span> carsImported;<font></font>
<font></font>
    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title function_">importCars</span><span class="hljs-params">(<span class="hljs-type">int</span> numberOfCars)</span><font></font>
    {<font></font>
        <span class="hljs-comment">// Update private field from public method</span><font></font>
        carsImported = carsImported + numberOfCars;<font></font>
    }<font></font>
}<font></font>
</code></pre>
</div></div><div class="instructions"><h2><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Instruções</font></font></h2><div class="content"><p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Neste exercício, você brincará com um carrinho de controle remoto, para o qual finalmente economizou dinheiro suficiente para comprar.</font></font></p>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Os carros começam com baterias cheias (100%). Cada vez que você dirige o carro usando o controle remoto, ele percorre 20 metros e drena um por cento da bateria.</font></font></p>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">O carro controlado remotamente tem um display LED sofisticado que mostra duas informações:</font></font></p>
<ul>
<li><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">A distância total percorrida, exibida como: </font></font><code>"Driven &lt;METERS&gt; meters"</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">.</font></font></li>
<li><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">A carga restante da bateria, exibida como: </font></font><code>"Battery at &lt;PERCENTAGE&gt;%"</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">.</font></font></li>
</ul>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Se a bateria estiver em 0%, você não poderá mais dirigir o carro e o visor da bateria mostrará </font></font><code>"Battery empty"</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">.</font></font></p>
<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Você tem seis tarefas, cada uma das quais trabalhará com instâncias de carros controlados remotamente.</font></font></p>
</div><details class="c-details task" open=""><summary class="--summary"><div class="--summary-inner"><div class="task-marker"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tarefa </font></font><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">1</font></font></div><span class="summary-title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Compre um carro novo com controle remoto</font></font></span><span class="--closed-icon"></span></div></summary><div><p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Implemente o método ( </font></font><em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">estático</font></font></em><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> ) </font></font><code>ElonsToyCar.buy()</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">para retornar uma nova instância de carro controlado remotamente:</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-type">ElonsToyCar</span> <span class="hljs-variable">car</span> <span class="hljs-operator">=</span> ElonsToyCar.buy();
</code></pre>
</div><div><button class="btn-default btn-s hints-btn"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Preso? Revele dicas</font></font></span></button></div></details><details class="c-details task"><summary class="--summary"><div class="--summary-inner"><div class="task-marker"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tarefa </font></font><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">2</font></font></div><span class="summary-title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Exibir a distância percorrida</font></font></span><span class="--closed-icon"></span><span class="--open-icon"></span></div></summary><div><p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Implemente o </font></font><code>ElonsToyCar.distanceDisplay()</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">método para retornar a distância conforme exibida no display LED:</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-type">ElonsToyCar</span> <span class="hljs-variable">car</span> <span class="hljs-operator">=</span> ElonsToyCar.buy();<font></font>
car.distanceDisplay();<font></font>
<span class="hljs-comment">// =&gt; "Driven 0 meters"</span>
</code></pre>
</div><div><button class="btn-default btn-s hints-btn"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Preso? Revele dicas</font></font></span></button></div></details><details class="c-details task"><summary class="--summary"><div class="--summary-inner"><div class="task-marker"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tarefa </font></font><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">3</font></font></div><span class="summary-title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Exibir a porcentagem da bateria</font></font></span><span class="--closed-icon"></span><span class="--open-icon"></span></div></summary><div><p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Implemente o </font></font><code>ElonsToyCar.batteryDisplay()</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">método para retornar a porcentagem da bateria conforme exibida no display LED:</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-type">ElonsToyCar</span> <span class="hljs-variable">car</span> <span class="hljs-operator">=</span> ElonsToyCar.buy();<font></font>
car.batteryDisplay();<font></font>
<span class="hljs-comment">// =&gt; "Battery at 100%"</span>
</code></pre>
</div><div><button class="btn-default btn-s hints-btn"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Preso? Revele dicas</font></font></span></button></div></details><details class="c-details task"><summary class="--summary"><div class="--summary-inner"><div class="task-marker"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tarefa </font></font><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">4</font></font></div><span class="summary-title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Atualizar o número de metros percorridos ao dirigir</font></font></span><span class="--closed-icon"></span><span class="--open-icon"></span></div></summary><div><p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Implemente o </font></font><code>ElonsToyCar.drive()</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">método que atualiza o número de metros percorridos:</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-type">ElonsToyCar</span> <span class="hljs-variable">car</span> <span class="hljs-operator">=</span> ElonsToyCar.buy();<font></font>
car.drive();<font></font>
car.drive();<font></font>
car.distanceDisplay();<font></font>
<span class="hljs-comment">// =&gt; "Driven 40 meters"</span>
</code></pre>
</div><div><button class="btn-default btn-s hints-btn"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Preso? Revele dicas</font></font></span></button></div></details><details class="c-details task"><summary class="--summary"><div class="--summary-inner"><div class="task-marker"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tarefa </font></font><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">5</font></font></div><span class="summary-title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Atualizar a porcentagem da bateria ao dirigir</font></font></span><span class="--closed-icon"></span><span class="--open-icon"></span></div></summary><div><p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Atualize o </font></font><code>ElonsToyCar.drive()</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">método para atualizar a porcentagem da bateria:</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-type">ElonsToyCar</span> <span class="hljs-variable">car</span> <span class="hljs-operator">=</span> ElonsToyCar.buy();<font></font>
car.drive();<font></font>
car.drive();<font></font>
car.batteryDisplay();<font></font>
<span class="hljs-comment">// =&gt; "Battery at 98%"</span>
</code></pre>
</div><div><button class="btn-default btn-s hints-btn"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Preso? Revele dicas</font></font></span></button></div></details><details class="c-details task"><summary class="--summary"><div class="--summary-inner"><div class="task-marker"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Tarefa </font></font><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">6</font></font></div><span class="summary-title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Evite dirigir quando a bateria estiver descarregada</font></font></span><span class="--closed-icon"></span><span class="--open-icon"></span></div></summary><div><p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Atualizar o </font></font><code>ElonsToyCar.drive()</code><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">método para não aumentar a distância percorrida nem diminuir a porcentagem da bateria quando ela estiver descarregada (em 0%):</font></font></p>
<pre><code class="language-java hljs" data-highlighted="true"><span class="hljs-type">ElonsToyCar</span> <span class="hljs-variable">car</span> <span class="hljs-operator">=</span> ElonsToyCar.buy();<font></font>
<font></font>
<span class="hljs-comment">// Drain the battery</span>
<span class="hljs-comment">// ...</span><font></font>
<font></font>
car.distanceDisplay();<font></font>
<span class="hljs-comment">// =&gt; "Driven 2000 meters"</span><font></font>
<font></font>
car.batteryDisplay();<font></font>
<span class="hljs-comment">// =&gt; "Battery empty"</span>
</code></pre>
</div><div><button class="btn-default btn-s hints-btn"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Preso? Revele dicas</font></font></span></button></div></details></div></div></section>