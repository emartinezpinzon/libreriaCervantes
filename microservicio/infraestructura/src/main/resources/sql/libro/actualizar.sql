update libro
set titulo = :titulo,
	categoria = :categoria,
	distribucion = :distribucion,
	disponibles = :disponibles,
	precio = :precio
where id = :id