/* JS Document */

/******************************

[Table of Contents]

1. Vars and Inits
2. Set Header
3. Init Menu
4. Init Home Slider
5. Init Featured Album Player
6. InitMagic
7. Init Single Player


******************************/

$(document).ready(function()
{
	"use strict";

	/* 

	1. Vars and Inits

	*/

	var header = $('.header');
	var ctrl = new ScrollMagic.Controller();

	initMenu();
	initHomeSlider();
	initAlbumPlayer();
	initMagic();
	initSinglePlayer();

	setHeader();

	$(window).on('resize', function()
	{
		setHeader();
	});

	$(document).on('scroll', function()
	{
		setHeader();
	});

	/* 

	2. Set Header

	*/

	function setHeader()
	{
		if($(window).scrollTop() > 91)
		{
			header.addClass('scrolled');
		}
		else
		{
			header.removeClass('scrolled');
		}
	}

	/* 

	3. Init Menu

	*/

	function initMenu()
	{
		if($('.menu').length)
		{
			var hamb = $('.hamburger');
			var menu = $('.menu');
			var menuOverlay = $('.menu_overlay');

			hamb.on('click', function()
			{
				menu.addClass('active');
			});

			menuOverlay.on('click', function()
			{
				menu.removeClass('active');
			});
		}
	}

	/* 

	4. Init Home Slider

	*/

	function initHomeSlider()
	{
		if($('.home_slider').length)
		{
			var homeSlider = $('.home_slider');
			homeSlider.owlCarousel(
			{
				animateOut: 'fadeOutLeft',
    			animateIn: 'fadeInRight',
				items:1,
				loop:true,
				autoplay:false,
				autoplayTimeout:8000,
				smartSpeed:1200,
				autoplaySpeed:1200,
				dotsSpeed:1200,
				mouseDrag:false,
				nav:false,
				dots:true,
				margin:250
			});
		}
	}

});
