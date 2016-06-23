
# parsetab.py
# This file is automatically generated. Do not edit.
_tabversion = '3.2'

_lr_method = 'SLR'

_lr_signature = '\xf1#\x1a\x19:\n\xda&\x9d\x0b\x05\x94\xa5>\x1e\xba'
    
_lr_action_items = {'ATTRVALUE1STRING':([29,],[32,]),'TAGATTRNAME':([1,7,16,21,28,34,35,],[7,15,15,27,-12,-13,-14,]),'TAGCLOSE':([6,7,12,16,17,18,24,27,28,34,35,],[-19,-19,-19,-19,26,-11,-10,31,-12,-13,-14,]),'PCDATA':([0,3,4,6,8,10,11,12,22,25,26,31,],[2,9,-6,10,19,-18,-17,10,-5,-9,-7,-8,]),'CLOSETAGOPEN':([4,6,7,10,11,12,13,14,16,20,22,25,26,31,],[-6,-19,-19,-18,-17,-19,21,-16,-19,-15,-5,-9,-7,-8,]),'ATTRVALUE1OPEN':([23,],[29,]),'ATTRVALUE1CLOSE':([32,],[34,]),'ATTRVALUE2CLOSE':([33,],[35,]),'LONETAGCLOSE':([6,7,12,16,17,18,24,28,34,35,],[-19,-19,-19,-19,25,-11,-10,-12,-13,-14,]),'ATTRASSIGN':([15,],[23,]),'OPENTAGOPEN':([0,2,4,6,10,11,12,22,25,26,31,],[1,1,-6,1,-18,-17,1,-5,-9,-7,-8,]),'ATTRVALUE2OPEN':([23,],[30,]),'ATTRVALUE2STRING':([30,],[33,]),'$end':([3,4,5,8,9,19,22,25,31,],[-1,-6,0,-3,-2,-4,-5,-9,-8,]),}

_lr_action = { }
for _k, _v in _lr_action_items.items():
   for _x,_y in zip(_v[0],_v[1]):
      if not _x in _lr_action:  _lr_action[_x] = { }
      _lr_action[_x][_k] = _y
del _lr_action_items

_lr_goto_items = {'attribute':([7,16,],[16,16,]),'closetag':([13,],[22,]),'attrvalue':([23,],[28,]),'lonetag':([0,2,6,12,],[4,4,4,4,]),'child':([6,12,],[12,12,]),'attributes':([7,16,],[17,24,]),'element':([0,2,6,12,],[3,8,11,11,]),'root':([0,],[5,]),'children':([6,12,],[13,20,]),'empty':([6,7,12,16,],[14,18,14,18,]),'opentag':([0,2,6,12,],[6,6,6,6,]),}

_lr_goto = { }
for _k, _v in _lr_goto_items.items():
   for _x,_y in zip(_v[0],_v[1]):
       if not _x in _lr_goto: _lr_goto[_x] = { }
       _lr_goto[_x][_k] = _y
del _lr_goto_items
_lr_productions = [
  ("S' -> root","S'",1,None,None,None),
  ('root -> element','root',1,'p_root_element','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',190),
  ('root -> element PCDATA','root',2,'p_root_element','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',191),
  ('root -> PCDATA element','root',2,'p_root_pcdata_element','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',198),
  ('root -> PCDATA element PCDATA','root',3,'p_root_pcdata_element','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',199),
  ('element -> opentag children closetag','element',3,'p_element','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',206),
  ('element -> lonetag','element',1,'p_element','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',207),
  ('opentag -> OPENTAGOPEN TAGATTRNAME attributes TAGCLOSE','opentag',4,'p_opentag','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',218),
  ('closetag -> CLOSETAGOPEN TAGATTRNAME TAGCLOSE','closetag',3,'p_closetag','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',226),
  ('lonetag -> OPENTAGOPEN TAGATTRNAME attributes LONETAGCLOSE','lonetag',4,'p_lonetag','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',235),
  ('attributes -> attribute attributes','attributes',2,'p_attributes','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',243),
  ('attributes -> empty','attributes',1,'p_attributes','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',244),
  ('attribute -> TAGATTRNAME ATTRASSIGN attrvalue','attribute',3,'p_attribute','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',258),
  ('attrvalue -> ATTRVALUE1OPEN ATTRVALUE1STRING ATTRVALUE1CLOSE','attrvalue',3,'p_attrvalue','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',265),
  ('attrvalue -> ATTRVALUE2OPEN ATTRVALUE2STRING ATTRVALUE2CLOSE','attrvalue',3,'p_attrvalue','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',266),
  ('children -> child children','children',2,'p_children','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',274),
  ('children -> empty','children',1,'p_children','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',275),
  ('child -> element','child',1,'p_child_element','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',288),
  ('child -> PCDATA','child',1,'p_child_pcdata','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',294),
  ('empty -> <empty>','empty',0,'p_empty','C:\\git\\mcap\\java-tools\\flow-parser\\parser.py',301),
]