CREATE TABLE `test_entity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
CREATE TABLE test_native (id int, value1 varchar(255), value2 int, primary key(id));
INSERT INTO test_native VALUES (1, 'test text1', 55);
INSERT INTO test_native VALUES (2, 'test text2', 66);