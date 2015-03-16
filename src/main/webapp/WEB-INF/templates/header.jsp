<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-2.1.3.js"></script>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Assignment 3: Stock Application</title>
		<style type="text/css">
		h1 {color:white; font-size:26pt; text-align:center;
			font-family:arial, sans-serif; font-weight:bold}
		.menu {color:white; font-size:14pt; text-align:center;
			font-family:arial, sans-serif; font-weight:bold}
		h2 {color:black; font-size:16pt; text-align:center;
			font-family:arial, sans-serif; font-weight:bold}
		table.footerTable {position:absolute; bottom:0px; width:99%}
		td {background:purple; font-family:arial, sans-serif}
		p {color:black; font-size:16pt;
			font-family:arial, sans-serif; font-weight:bold}
		p.footer {color:white; font-size:8pt; text-align:center;
			font-family:arial, sans-serif; font-weight:bold}
	</style>
</head>

<body>
	<!-- the header for the page -->
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr bgcolor="white">
		<td  align="left"></td>
		<td>
			<h1>Assignment 3: Stock Application</h1>
		</td>
		<td background="purple" align="right"></td>
	</tr>
	<tr></tr>
	</table>
	<tr></tr>
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
	</table>	
	<!-- Menu Bar -->
		<!-- menu bar -->
	<table width="100%" bgcolor="white" cellpadding="4" cellspacing="0">
	<tr>
		<!-- Home Link -->
		<td width="25%">
			<span class="menu"><a style="color:white" href="/">Home</a><span>
		</td>
		<!-- Stock Prices Link -->
		<td width="25%">
			<span class="menu"><a style="color:white" href="/viewstocks">View Stock Prices</a><span>
		</td>
		<!-- User Auth Link -->
		<td width="25%">
			<span class="menu"><a style="color:white" href="/registration">Register</a><span>
		</td>
		<!-- Contact Us Link -->
		<td width="25%">
			<span class="menu"><a style="color:white" href="/Contact">Contact Us</a><span>
		</td>
		<!-- Intialize Link -->
		<td width="25%">
			<span class="menu"><a style="color:white" href="/intialize">Intialize</a><span>
		</td>
	</tr>
	</table>