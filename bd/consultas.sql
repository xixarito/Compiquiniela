DELIMITER //
CREATE PROCEDURE comp_spc_liga
BEGIN
  SELECT LigaId, NomCorto, Descripcion, PaisId FROM LIGA;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE comp_spc_torneo
(IN LigaIdConsulta MEDIUMINT)
BEGIN
  SELECT TorneoId, LigaId, NomCorto, Descripcion FROM TORNEO
  WHERE LigaId = LigaIdConsulta;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE comp_spc_jornada
(IN TorneoIdConsulta MEDIUMINT)
BEGIN
  SELECT JornadaId, TorneoId, NomCorto, Descripcion, FecInicio FROM JORNADA
  WHERE TorneoId = TorneoIdConsulta;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE comp_spc_partido
(IN JornadaIdConsulta MEDIUMINT)
BEGIN
  SELECT PartidoId, JornadaId, EquipoLocalId, EquipoVisitanteId, EstadioId, Fecha, Hora FROM PARTIDO
  WHERE JornadaId = JornadaIdConsulta;
END //
DELIMITER ;