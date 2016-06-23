#!/usr/bin/python

import unittest
from xmlp.xml_lex import XmlLexer
from datetime import datetime

class UtXmlLexer(unittest.TestCase):
    '''complex query test driver'''
    
    # test a simple xml
    def test_simple(self):
        data = open('pd-on.xml').read()
#         print data
        #data = '<Products>  <Product pid="p123">    <Name>gizmo</Name>    <Price>22.99</Price>    <Description>great</Description>    <Store>      <Name>wiz</Name>      <Phone>555-1234</Phone>      <Markup>25</Markup>    </Store>    <Store>      <Name>Econo-Wiz</Name>      <Phone>555-6543</Phone>      <Markup>15</Markup>    </Store>  </Product>  <Product pid="p231">    <Name>gizmoPlus</Name>    <Price>99.99</Price>    <Description>more features</Description>    <Store>      <Name>wiz</Name>      <Phone>555-1234</Phone>      <Markup>10</Markup>    </Store>  </Product>  <Product pid="p312">    <Name>gadget</Name>    <Price>59.99</Price>    <Description>good value</Description>  </Product></Products>'
        l = XmlLexer(debug=False).lexer
        l.input(data)
        
        while True:
            token = l.token()
            if not token: break
            print token
    #         self.lexer.test(data)