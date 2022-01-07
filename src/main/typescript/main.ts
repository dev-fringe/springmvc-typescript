import $ from 'jquery'
import Livro from './models/livro'
const Fada=new Livro('Fada',10.89,5,0.3)
$.ajax({
  url: "test"
}).done(function(res) {
  console.log(res);
});
$('body').append(`<h1>Descri테스트: ${Fada.describe()}</h1>`)
$('body').append(`<h2>Pre챌o com desconto: R$ ${Fada.desc()}</h2>`)
