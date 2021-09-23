select c.id, c.libroId, l.titulo, l.categoria, l.distribucion, l.disponibles, l.precio, c.cantidad
from compra c
join libro l
on c.libroId = l.id