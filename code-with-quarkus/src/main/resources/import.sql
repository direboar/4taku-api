drop table if exists gift;
drop table if exists Hero;
drop table if exists TierTable;

create table gift(
    id   int primary key,
    name varchar(100)
);

create table Hero(
    id int primary key,
    battlenetId int not null,
    name varchar(128) not null,
    displayName varchar(128) not null,
    imageURL varchar(128) not null,
    invalid boolean default false
);
create table TierTable(
    id   int primary key,
    name varchar(128) not null,
    ownerid int,
    tiers jsonb
);


INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(1,59397,'Patchwerk','パッチウァーク','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/1d387b97b0681474da04b0207561fe3c688cf987ac3bcdc118b42a63db5422f9.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(2,74631,'Kurtrus Ashfallen','カートラス・アッシュフォールン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/791be7c00632456f1ff4ab7e5419418d222d2cb717f4e2cb955f3399c85a01a2.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(3,64400,'Rakanishu','ラカニシュ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/ec519918ed7a76f2d388bf8670ecb9be5ae6c395b4caac8018f199f17285047d.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(4,64403,'Al''Akir','アラキア','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/274f02663df0e8dc82c4dcfeb61b31f7f784637a88676884dcb957932d8e006c.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(5,76562,'Scabbs Cutterbutter','スキャブス・カッターバター','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/f01981e6643c68b3ed185b4c8799ddf053a23d1523099bb1433e2d2491f7d623.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(6,66196,'Y''Shaarj','ヤシャラージュ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/0fea04c0afe040e12deee9c61f94c51c3b548ecf761abae9694cc60e79efee51.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(7,74646,'Tamsin Roame','タムシン・ローム','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/7a8fc60c747d1cba6720d5c8c4fe9142a9be69fb8c655337ec622d4b463d3c1f.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(8,67356,'Tickatus','チケッタス','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/828e1f903990ad932d9caabcb3f73ecd6de4b0a6d2ec2aa27671cbd67ae9526a.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(9,59805,'Yogg-Saron, Hope''s End','希望の終焉ヨグ＝サロン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/fce85cd0b8dccfdf6ecd3a4ebd247b6d15c5b32638f329e169abb5b13f3c8abe.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(10,59806,'Dancin'' Deryl','ダンシン・ダリル','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/8a65b37e721d2cf78b80ea978fe04dca40425395bedd95b6db86c1f82c100686.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(11,59807,'Lord Jaraxxus','ロード・ジャラクサス','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/14d96fc27aa321904975f0c743873b43e28833dadf76f0e886e126454ed76663.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(12,71454,'Overlord Saurfang','サウルファング元帥','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/c5b18898ca3b19b55777cc3a44539170db573b1ab2c4db996199448f21342428.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(13,81569,'Ambassador Faelin','フェイリン大使','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/8901ae71e503184ca71fba78b730bd8608690b184b055beb21f4493e67d1ba87.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(14,68129,'Guff Runetotem','ガフ・ルーントーテム','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/bfd565532f975de7e837cd1e5f140a565edf6d8e896c6b1404b988fb7954efa8.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(15,57633,'Edwin VanCleef','エドウィン・ヴァンクリーフ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/c50fd93ecace3978f674d12fa8a9e8eb1d2867946cc99218ba8530bda85284f6.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(16,62242,'Captain Eudora','ユードラ船長','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/66ec00761136d53dba0ecb6c59f7ae55377977e13d823e890bc4a4352b59714d.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(17,57634,'Illidan Stormrage','イリダン・ストームレイジ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/0358334ac019bce5e413b78593ee410114f107a489fba2372830080e98764838.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(18,77987,'Tavish Stormpike','タヴィッシュ・ストームパイク','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/97dc2f42262c9fe978c9ecee050ff58d807d4c203002cb126741cafffc0b1329.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(19,71458,'Death Speaker Blackthorn','死の説教師ブラックソーン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/afc881d990906fd62e9d221d5f1ec928b62f175ca3049b242ee41a18c9d19c4b.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(20,57635,'Galakrond','ガラクロンド','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/07c45c336ae8fc9c8ef5ca696b3a4bf774e83e7c589b9df7183a3d2ebe55cc25.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(21,57891,'Trade Prince Gallywix','商大公ガリーウィックス','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/0877ee7d603146c60a7b5d107a646d48ef6fa829f19d96bb8e15d303f3485942.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(22,57892,'Ragnaros the Firelord','炎の王ラグナロス','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/7cc24e352740fbc5824a075960e08a1ed20074cd8d6a64346c205f2b0815aa81.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(23,58021,'The Great Akazamzarak','偉大なるアカザムザラク','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/139ba43ac008ef7e033561971c5d967bb9aa24ece5319e0c781fcdde04909be3.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(24,57893,'The Rat King','ネズミの王','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/9bd868fcec750b39ef26c69794f04304b62f68b32afc8749756a2773cdddc428.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(25,58534,'Infinite Toki','無限のトキ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/732e82e67c08967a2ee0e60ade8b3deeb180cc00d875d3cfb58c42f8ccae476f.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(26,59814,'King Mukla','キング・ムクラ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/1f7cc4e32e5853810f55d64000e4f6a0ab028770e9cd58d8cee1d2e9460d1285.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(27,71463,'Vol''jin','ヴォルジン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/7631e698168e3bd80882297011c7c29c4159b1778a670f5b187935f3834359b8.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(28,58535,'C''Thun','クトゥーン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/2df208dfc65ddfe0128401da4c10a583c88365c8b2a4b74bd5309ff5b8a37138.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(29,58024,'The Lich King','リッチキング','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/4683717cf68505f663dd188eeb19fc91c6f6b4f382907d749a4004c243d099a9.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(30,58027,'Shudderwock','シャダウォック','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/aa03a1788e0ae7a1aa234a95e1054bff073294d56d6d65499291a2c40762abf2.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(31,70956,'Xyrella','ザイレラ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/be2bcdae63cc73d29b0339a678f4697c27a126cb94f81430b0b249d56c3695a3.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(32,61488,'Alexstrasza','アレクストラーザ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5030576a4c3ba0a107fba6555992f8c7ec00e1f25b32ac1d4f22968446d6da96.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(33,61489,'Nozdormu','ノズドルム','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/a8314827e023ec28827cb93b07723f7228960207f44c4ba0d0edc088e1ef14b3.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(34,61490,'Malygos','マリゴス','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5079d41ec204909d985efe2fbb3a4dc8012d831f4e48158fafc1694a23048c9e.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(35,66483,'N''Zoth','ン＝ゾス','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/66eddb5e6ff78df69755d6ccd3553244ce13acfb40a3288ac5e66fc7c87a193e.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(36,60211,'Sir Finley Mrrgglton','サー・フィンレー・マルグルトン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/6109866b51340e5e07bf6375208320b36a0cc0b1e6aa75ce97c56d58a7992d42.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(37,60212,'Reno Jackson','レノ・ジャクソン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/543e7603d1bae9fe73d9732705097885ba3b190486ae4399c48b99be065c57bf.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(38,60213,'Elise Starseeker','エリーズ・スターシーカー','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5f4017e0be158010e8038b1f545ad87e10b6a5831085b073aa834bfe9fdb993c.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(39,60214,'Dinotamer Brann','恐竜使いブラン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/9af5508f3631537cb2365db972e4ff599e7a1bf47992ea6688e1bb122ff53bd9.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(40,75702,'Galewing','ゲイルウィング','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/cddd94824d3932574f9cfc20818e28da6ba85680e335bdf20feb2d54157e3ab3.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(41,59831,'Pyramad','ピラマッド','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/5c100a4f8893009c1acaee69b85f0c597121eb0ba4bf967ba3331ce49df6f95d.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(42,70838,'Rokara','ロカラ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/89d4376ebb527ee9dfbf507c9c884e011e5080a2df8b3da0f50d92da07482ade.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(43,62266,'Captain Hooktusk','フックタスク船長','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/1ce2787df1f9aecd49674b624321797ddc8ec9d23604f0348626208cda4b4d2d.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(44,58044,'Lich Baz''hial','リッチのバズィアル','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/b2336e31d7359734ae2af83f4284768f34a08cbabb4e46ba3d4c969b363bc896.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(45,62268,'Skycap''n Kragg','空賊船長クラッグ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/26ac2db27bba2ed4a19a50b2c0ed42aa3c09955b7dac61595832c027564ed318.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(46,82110,'Onyxia','オニクシア','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/65db872b4b0b74db505afeb25b993cf2820be3c518a1b313037741bae14824f8.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(47,80832,'Ini Stormcoil','イニ・ストームコイル','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/42156f91eeb13ea34326e9e6b408a1b0ac0adb6084e588d848727c8b5c9b28ee.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(48,58435,'Sindragosa','シンドラゴサ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/6e2dd8c00793911b799afe6e816f15b27e201ac2e20192a10e95c2434d2cbb03.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(49,59203,'The Curator','キュレーター','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/47330a0e86f56bdd4c97c6efb47eba16c33076218f73c7ee463ac3f5a2f731eb.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(50,57924,'Queen Wagtoggle','ワグトグル女王','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/071325811df1676f8eb3b947b35ad631f13f8fbf2f72946dc2dd9370750eeccf.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(51,57929,'George the Fallen','地獄のジョージ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/7d0d33ee4ce7cc6c8cca1ea00a40388bf49608ebbace0d3abf88dbb449a3a6d0.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(52,60362,'Arch-Villain Rafaam','大悪党ラファーム','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/fa296e6f861c4ddb01b91e84b7c6d8e06fa5eb165c169ed541d213c4a09fd081.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(53,77516,'Cookie the Cook','コックのクッキー','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/e65ac937843040290e774e0f8475105a9742854e95e394ff091d90637dc63e94.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(54,60366,'Millhouse Manastorm','ミルハウス・マナストーム','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/ca9c2bca8b69f82ca5e78aa624bf40d8aa580cf4ee72db71d0c28dbe008628f2.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(55,60367,'Tess Greymane','テス・グレイメイン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/8115b0919ee4392a3a5012e586671cc3ae5814cd57d387c5002ba5faf8891b56.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(56,60369,'Deathwing','デスウィング','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/3e6132fdd5122e1de82250b2fd961ada63276dda3f17ff56b33443b70037a1b4.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(57,60370,'Ysera','イセラ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/544506223601094837b297ad0cf78c9229d63936283a139f366e88cd947f86e9.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(58,60372,'Fungalmancer Flurgl','菌術師フラァグル','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/7142c587b63d745bdbf847c98c2ff022beeeb7d90499e43e67222375eaa14bba.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(59,73940,'Cariel Roame','キャリエル・ローム','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/847e91cac741a2c9770455b9d536142593f1e07532694e88a659cc55355e9d13.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(60,61910,'Aranna Starseeker','アランナ・スターシーカー','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/fdb481e8cd6e7b83cf9ebb1fe017eeb3f67c2aacfdbadce6b47249e70aaf73c1.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(61,63319,'Mr. Bigglesworth','ビグルスワース君','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/33f89c9ea62da00c26b8c0fd3a1253483f4a29b443b45dd1a718c2c268543c10.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(62,57944,'A. F. Kay','A. F. ケイ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/d52dfb306417c35716e65a8f3c78b128921d472e4b1015b2965fe5817480938c.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(63,61912,'Kael''thas Sunstrider','ケルサス・サンストライダー','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/3adadf67f94b9756da03e93e7e4de2d390137e7c564313230ed4fd3ab8d56f26.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(64,61914,'Maiev Shadowsong','マイエヴ・シャドウソング','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/3cea1d87ee909744de91dc03e1029380928f803857b17849a33ec43d9fcc5c6f.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(65,57946,'Millificent Manastorm','ミリフィセント・マナストーム','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/43c880a484d0698ee19d40be670a328e62aff09a25e4d5059cac7b4621ec7b20.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(66,64475,'Chenvaala','シェンヴァーラ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/567deba049c981d1bf652339900f9497c675f14160b1852b9b2b0480533831d4.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(67,57947,'Patches the Pirate','海賊パッチーズ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/27a84a9527dcb175c4c022ef22ac967f1d103d16b39ded2b2dcdefbaf73bf40f.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(68,67553,'Greybough','灰枝','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/77f2cab92f4b3e1733d2ed26c89c626b9f595128ccc6f98030262ce1b97f1fc3.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(69,64480,'Silas Darkmoon','サイラス・ダークムーン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/fd668c17b7f31f5bf50d9f3ed3c0afb84e3dccd516a0b24936a8da8fda4f5d12.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(70,71908,'Master Nguyen','マスター・ウェン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/e51b391fcb32e1b227cf10ac2cdce17ec925d0e16e5f07cd54e0a7e7f0798541.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(71,64485,'Zephrys, the Great','偉大なるゼフリス','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/3b12d95b5e8886cab7f023b95e39dbf65b9dd98c61d7590f25438b076c0d4638.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(72,79719,'Bru''kan','ブルカン','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/36e8fccc57a7ceea92e90425c01399ae4c7a8935cc7f1b87e58f3cfaf8b5f111.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(73,76521,'Sneed','スニード','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/beb48f3f0cb91b8869a7240ab1e01e3a021ff22a3c2c515b9f374e2af8c406f1.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(74,71916,'Mutanus the Devourer','貪り喰らうものミュターヌス','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/487b807851b95a41a9a4dcc3798816e0ae6850622ee8bd9fbe77bdc7c8d7921b.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(75,80239,'Drek''Thar','ドレクサー','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/b4b2ba5d261213dd534d7afde1cebc1888d4df4f37b113b3bf28a5f6733da75f.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(76,63601,'Jandice Barov','ジャンディス・バロフ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/e7e8d783bef001284194c6abd2ea7bbbfc382703683b6f56ee2df2e3488b116e.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(77,63602,'Lord Barov','ロード・バロフ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/1003453753b0929bbbcd7c4fc7ba3187606c2b2299d137aac99f3b6556a50d72.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(78,63604,'Forest Warden Omu','森番オム','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/7c94508e9bf4a70cd8563fcb8180a3b7c43455425cebb8b7f396fd46125404cc.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(79,80247,'Vanndar Stormpike','ヴァンダル・ストームパイク','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/8158bce864426f5d656e6d37f1ba3bec3b069faf7d64583036359c24eb400845.png',false);
INSERT INTO hero(id,battlenetid,name,displayname,imageurl,invalid) VALUES(80,79615,'Varden Dawngrasp','ヴァーデン・ドーングラスプ','https://d15f34w2p8l1cc.cloudfront.net/hearthstone/4040fa5178622ee142c803ac0d9fdde9b43906bc0793570491d42aeab8d2c250.png',false);

insert into TierTable values (10001, 'tier表 1',1,null);
insert into TierTable values (10002, 'tier表 2',1,null);
insert into TierTable values (10003, 'tier表 3',1,null);
insert into TierTable values (10004, 'tier表 4',1,null);
insert into TierTable values (10005, 'tier表 5',1,null);
insert into TierTable values (10006, 'tier表 6',1,null);
insert into TierTable values (10007, 'tier表 7',1,null);
insert into TierTable values (10008, 'tier表 8',1,null);
insert into TierTable values (10009, 'tier表 9',1,null);
insert into TierTable values (10010, 'tier表10',1,null);
insert into TierTable values (10011, 'tier表11',1,null);
insert into TierTable values (10012, 'tier表12',1,null);
insert into TierTable values (10013, 'tier表13',1,null);
insert into TierTable values (10014, 'tier表14',1,null);
insert into TierTable values (10015, 'tier表15',1,null);
insert into TierTable values (10016, 'tier表16',1,null);
insert into TierTable values (10017, 'tier表17',1,null);
insert into TierTable values (10018, 'tier表18',1,null);
insert into TierTable values (10019, 'tier表19',1,null);
insert into TierTable values (10020, 'tier表20',1,null);
insert into TierTable values (10021, 'tier表21',1,null);
insert into TierTable values (10022, 'tier表22',1,null);
insert into TierTable values (10023, 'tier表23',1,null);
insert into TierTable values (10024, 'tier表24',1,null);
insert into TierTable values (10025, 'tier表25',1,null);
insert into TierTable values (10026, 'tier表26',1,null);
insert into TierTable values (10027, 'tier表27',1,null);
insert into TierTable values (10028, 'tier表28',1,null);
insert into TierTable values (10029, 'tier表29',1,null);
insert into TierTable values (10030, 'tier表30',1,null);
insert into TierTable values (10031, 'tier表31',1,null);
insert into TierTable values (10032, 'tier表32',1,null);
insert into TierTable values (10033, 'tier表33',1,null);
insert into TierTable values (10034, 'tier表34',1,null);
insert into TierTable values (10035, 'tier表35',1,null);
insert into TierTable values (10036, 'tier表36',1,null);
insert into TierTable values (10037, 'tier表37',1,null);
insert into TierTable values (10038, 'tier表38',1,null);
insert into TierTable values (10039, 'tier表39',1,null);
insert into TierTable values (10040, 'tier表40',1,null);
insert into TierTable values (10041, 'tier表41',1,null);
insert into TierTable values (10042, 'tier表42',1,null);
insert into TierTable values (10043, 'tier表43',1,null);
insert into TierTable values (10044, 'tier表44',1,null);
insert into TierTable values (10045, 'tier表45',1,null);
insert into TierTable values (10046, 'tier表46',1,null);
insert into TierTable values (10047, 'tier表47',1,null);
insert into TierTable values (10048, 'tier表48',1,null);
insert into TierTable values (10049, 'tier表49',1,null);
insert into TierTable values (10050, 'tier表50',1,null);
insert into TierTable values (10051, 'tier表51',1,null);
insert into TierTable values (10052, 'tier表52',1,null);
insert into TierTable values (10053, 'tier表53',1,null);
insert into TierTable values (10054, 'tier表54',1,null);
insert into TierTable values (10055, 'tier表55',1,null);
insert into TierTable values (10056, 'tier表56',1,null);
insert into TierTable values (10057, 'tier表57',1,null);
insert into TierTable values (10058, 'tier表58',1,null);
insert into TierTable values (10059, 'tier表59',1,null);
insert into TierTable values (10060, 'tier表60',1,null);


