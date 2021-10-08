﻿using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace PoC_WPF
{
    /// <summary>
    /// Logique d'interaction pour App.xaml
    /// </summary>
    public partial class App : Application
    {
        /// <summary>
        /// Déclenche l'événement <see cref="E:System.Windows.Application.Startup" />.
        /// </summary>
        /// <param name="e"><see cref="T:System.Windows.StartupEventArgs" /> qui contient les données d'événement.</param>
        protected override void OnStartup(StartupEventArgs e)
        {
            //TODO:WPF1.2 Instantiate a new bootstrapper.
            Bootstrapper bootstrapper = new Bootstrapper();

            bootstrapper.Run();
        }
    }
}