<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.TabControl1 = New System.Windows.Forms.TabControl()
        Me.SalesTab = New System.Windows.Forms.TabPage()
        Me.ReturnFlawedButton = New System.Windows.Forms.Button()
        Me.SoldButton = New System.Windows.Forms.Button()
        Me.FlawedCodeTextBox = New System.Windows.Forms.TextBox()
        Me.FlawedCodeLabel = New System.Windows.Forms.Label()
        Me.SalesCodeTextBox = New System.Windows.Forms.TextBox()
        Me.SalesCodeLabel = New System.Windows.Forms.Label()
        Me.SearchTab = New System.Windows.Forms.TabPage()
        Me.SearchButton = New System.Windows.Forms.Button()
        Me.SearchTextBox = New System.Windows.Forms.TextBox()
        Me.ReferenceWordLabel = New System.Windows.Forms.Label()
        Me.SearchResultsListBox = New System.Windows.Forms.ListBox()
        Me.FindByLabel = New System.Windows.Forms.Label()
        Me.FindByComboBox = New System.Windows.Forms.ComboBox()
        Me.RentalsTab = New System.Windows.Forms.TabPage()
        Me.ReturnButton = New System.Windows.Forms.Button()
        Me.RentedButton = New System.Windows.Forms.Button()
        Me.ReturnedCodeTextBox = New System.Windows.Forms.TextBox()
        Me.ReturnedCodeLabel = New System.Windows.Forms.Label()
        Me.RentedCodeTextBox = New System.Windows.Forms.TextBox()
        Me.RentedCodeLabel = New System.Windows.Forms.Label()
        Me.BuyingTab = New System.Windows.Forms.TabPage()
        Me.NewItemButton = New System.Windows.Forms.Button()
        Me.RentalSaleTextBox = New System.Windows.Forms.TextBox()
        Me.RentalSaleLabel = New System.Windows.Forms.Label()
        Me.PriceTextBox = New System.Windows.Forms.TextBox()
        Me.PriceLabel = New System.Windows.Forms.Label()
        Me.NewItemLabel = New System.Windows.Forms.Label()
        Me.SizeTextBox = New System.Windows.Forms.TextBox()
        Me.SizeLabel = New System.Windows.Forms.Label()
        Me.TypeTextBox = New System.Windows.Forms.TextBox()
        Me.TypeLabel = New System.Windows.Forms.Label()
        Me.BrandTextBox = New System.Windows.Forms.TextBox()
        Me.BrandLabel = New System.Windows.Forms.Label()
        Me.ClearButton = New System.Windows.Forms.Button()
        Me.TabControl1.SuspendLayout()
        Me.SalesTab.SuspendLayout()
        Me.SearchTab.SuspendLayout()
        Me.RentalsTab.SuspendLayout()
        Me.BuyingTab.SuspendLayout()
        Me.SuspendLayout()
        '
        'TabControl1
        '
        Me.TabControl1.Controls.Add(Me.SalesTab)
        Me.TabControl1.Controls.Add(Me.SearchTab)
        Me.TabControl1.Controls.Add(Me.RentalsTab)
        Me.TabControl1.Controls.Add(Me.BuyingTab)
        Me.TabControl1.Location = New System.Drawing.Point(0, 0)
        Me.TabControl1.Name = "TabControl1"
        Me.TabControl1.SelectedIndex = 0
        Me.TabControl1.Size = New System.Drawing.Size(511, 380)
        Me.TabControl1.TabIndex = 0
        '
        'SalesTab
        '
        Me.SalesTab.BackColor = System.Drawing.Color.Teal
        Me.SalesTab.Controls.Add(Me.ReturnFlawedButton)
        Me.SalesTab.Controls.Add(Me.SoldButton)
        Me.SalesTab.Controls.Add(Me.FlawedCodeTextBox)
        Me.SalesTab.Controls.Add(Me.FlawedCodeLabel)
        Me.SalesTab.Controls.Add(Me.SalesCodeTextBox)
        Me.SalesTab.Controls.Add(Me.SalesCodeLabel)
        Me.SalesTab.Location = New System.Drawing.Point(4, 22)
        Me.SalesTab.Name = "SalesTab"
        Me.SalesTab.Padding = New System.Windows.Forms.Padding(3)
        Me.SalesTab.Size = New System.Drawing.Size(503, 354)
        Me.SalesTab.TabIndex = 0
        Me.SalesTab.Text = "Sales"
        '
        'ReturnFlawedButton
        '
        Me.ReturnFlawedButton.Location = New System.Drawing.Point(26, 214)
        Me.ReturnFlawedButton.Name = "ReturnFlawedButton"
        Me.ReturnFlawedButton.Size = New System.Drawing.Size(128, 28)
        Me.ReturnFlawedButton.TabIndex = 5
        Me.ReturnFlawedButton.Text = "Return Flawed"
        Me.ReturnFlawedButton.UseVisualStyleBackColor = True
        '
        'SoldButton
        '
        Me.SoldButton.Location = New System.Drawing.Point(26, 80)
        Me.SoldButton.Name = "SoldButton"
        Me.SoldButton.Size = New System.Drawing.Size(128, 29)
        Me.SoldButton.TabIndex = 4
        Me.SoldButton.Text = "Sold"
        Me.SoldButton.UseVisualStyleBackColor = True
        '
        'FlawedCodeTextBox
        '
        Me.FlawedCodeTextBox.Location = New System.Drawing.Point(308, 172)
        Me.FlawedCodeTextBox.Name = "FlawedCodeTextBox"
        Me.FlawedCodeTextBox.Size = New System.Drawing.Size(174, 20)
        Me.FlawedCodeTextBox.TabIndex = 3
        '
        'FlawedCodeLabel
        '
        Me.FlawedCodeLabel.AutoSize = True
        Me.FlawedCodeLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.FlawedCodeLabel.Location = New System.Drawing.Point(22, 172)
        Me.FlawedCodeLabel.Name = "FlawedCodeLabel"
        Me.FlawedCodeLabel.Size = New System.Drawing.Size(280, 20)
        Me.FlawedCodeLabel.TabIndex = 2
        Me.FlawedCodeLabel.Text = "Enter barcode of flawed item returned:"
        '
        'SalesCodeTextBox
        '
        Me.SalesCodeTextBox.Location = New System.Drawing.Point(231, 41)
        Me.SalesCodeTextBox.Name = "SalesCodeTextBox"
        Me.SalesCodeTextBox.Size = New System.Drawing.Size(174, 20)
        Me.SalesCodeTextBox.TabIndex = 1
        '
        'SalesCodeLabel
        '
        Me.SalesCodeLabel.AutoSize = True
        Me.SalesCodeLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.SalesCodeLabel.Location = New System.Drawing.Point(22, 41)
        Me.SalesCodeLabel.Name = "SalesCodeLabel"
        Me.SalesCodeLabel.Size = New System.Drawing.Size(203, 20)
        Me.SalesCodeLabel.TabIndex = 0
        Me.SalesCodeLabel.Text = "Enter barcode of item sold: "
        '
        'SearchTab
        '
        Me.SearchTab.BackColor = System.Drawing.Color.DarkOliveGreen
        Me.SearchTab.Controls.Add(Me.ClearButton)
        Me.SearchTab.Controls.Add(Me.SearchButton)
        Me.SearchTab.Controls.Add(Me.SearchTextBox)
        Me.SearchTab.Controls.Add(Me.ReferenceWordLabel)
        Me.SearchTab.Controls.Add(Me.SearchResultsListBox)
        Me.SearchTab.Controls.Add(Me.FindByLabel)
        Me.SearchTab.Controls.Add(Me.FindByComboBox)
        Me.SearchTab.Location = New System.Drawing.Point(4, 22)
        Me.SearchTab.Name = "SearchTab"
        Me.SearchTab.Padding = New System.Windows.Forms.Padding(3)
        Me.SearchTab.Size = New System.Drawing.Size(503, 354)
        Me.SearchTab.TabIndex = 1
        Me.SearchTab.Text = "Search"
        '
        'SearchButton
        '
        Me.SearchButton.Location = New System.Drawing.Point(385, 23)
        Me.SearchButton.Name = "SearchButton"
        Me.SearchButton.Size = New System.Drawing.Size(101, 45)
        Me.SearchButton.TabIndex = 5
        Me.SearchButton.Text = "Search"
        Me.SearchButton.UseVisualStyleBackColor = True
        '
        'SearchTextBox
        '
        Me.SearchTextBox.Location = New System.Drawing.Point(119, 83)
        Me.SearchTextBox.Name = "SearchTextBox"
        Me.SearchTextBox.Size = New System.Drawing.Size(252, 20)
        Me.SearchTextBox.TabIndex = 4
        '
        'ReferenceWordLabel
        '
        Me.ReferenceWordLabel.AutoSize = True
        Me.ReferenceWordLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.ReferenceWordLabel.Location = New System.Drawing.Point(45, 83)
        Me.ReferenceWordLabel.Name = "ReferenceWordLabel"
        Me.ReferenceWordLabel.Size = New System.Drawing.Size(68, 20)
        Me.ReferenceWordLabel.TabIndex = 3
        Me.ReferenceWordLabel.Text = "Search: "
        '
        'SearchResultsListBox
        '
        Me.SearchResultsListBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.SearchResultsListBox.FormattingEnabled = True
        Me.SearchResultsListBox.ItemHeight = 16
        Me.SearchResultsListBox.Location = New System.Drawing.Point(8, 120)
        Me.SearchResultsListBox.Name = "SearchResultsListBox"
        Me.SearchResultsListBox.Size = New System.Drawing.Size(489, 212)
        Me.SearchResultsListBox.TabIndex = 2
        '
        'FindByLabel
        '
        Me.FindByLabel.AutoSize = True
        Me.FindByLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.FindByLabel.Location = New System.Drawing.Point(45, 23)
        Me.FindByLabel.Name = "FindByLabel"
        Me.FindByLabel.Size = New System.Drawing.Size(68, 20)
        Me.FindByLabel.TabIndex = 1
        Me.FindByLabel.Text = "Find by: "
        '
        'FindByComboBox
        '
        Me.FindByComboBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.FindByComboBox.FormattingEnabled = True
        Me.FindByComboBox.Items.AddRange(New Object() {"Barcode (Ex: 00000000)", "Brand (Ex: K2)", "Type (Ex: Snowboard)"})
        Me.FindByComboBox.Location = New System.Drawing.Point(143, 23)
        Me.FindByComboBox.Name = "FindByComboBox"
        Me.FindByComboBox.Size = New System.Drawing.Size(216, 28)
        Me.FindByComboBox.TabIndex = 0
        '
        'RentalsTab
        '
        Me.RentalsTab.BackColor = System.Drawing.SystemColors.ControlDarkDark
        Me.RentalsTab.Controls.Add(Me.ReturnButton)
        Me.RentalsTab.Controls.Add(Me.RentedButton)
        Me.RentalsTab.Controls.Add(Me.ReturnedCodeTextBox)
        Me.RentalsTab.Controls.Add(Me.ReturnedCodeLabel)
        Me.RentalsTab.Controls.Add(Me.RentedCodeTextBox)
        Me.RentalsTab.Controls.Add(Me.RentedCodeLabel)
        Me.RentalsTab.Location = New System.Drawing.Point(4, 22)
        Me.RentalsTab.Name = "RentalsTab"
        Me.RentalsTab.Padding = New System.Windows.Forms.Padding(3)
        Me.RentalsTab.Size = New System.Drawing.Size(503, 354)
        Me.RentalsTab.TabIndex = 2
        Me.RentalsTab.Text = "Rentals"
        '
        'ReturnButton
        '
        Me.ReturnButton.Location = New System.Drawing.Point(40, 189)
        Me.ReturnButton.Name = "ReturnButton"
        Me.ReturnButton.Size = New System.Drawing.Size(134, 30)
        Me.ReturnButton.TabIndex = 7
        Me.ReturnButton.Text = "Return"
        Me.ReturnButton.UseVisualStyleBackColor = True
        '
        'RentedButton
        '
        Me.RentedButton.Location = New System.Drawing.Point(40, 80)
        Me.RentedButton.Name = "RentedButton"
        Me.RentedButton.Size = New System.Drawing.Size(134, 29)
        Me.RentedButton.TabIndex = 6
        Me.RentedButton.Text = "Rent"
        Me.RentedButton.UseVisualStyleBackColor = True
        '
        'ReturnedCodeTextBox
        '
        Me.ReturnedCodeTextBox.Location = New System.Drawing.Point(276, 153)
        Me.ReturnedCodeTextBox.Name = "ReturnedCodeTextBox"
        Me.ReturnedCodeTextBox.Size = New System.Drawing.Size(174, 20)
        Me.ReturnedCodeTextBox.TabIndex = 5
        '
        'ReturnedCodeLabel
        '
        Me.ReturnedCodeLabel.AutoSize = True
        Me.ReturnedCodeLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.ReturnedCodeLabel.Location = New System.Drawing.Point(36, 153)
        Me.ReturnedCodeLabel.Name = "ReturnedCodeLabel"
        Me.ReturnedCodeLabel.Size = New System.Drawing.Size(234, 20)
        Me.ReturnedCodeLabel.TabIndex = 4
        Me.ReturnedCodeLabel.Text = "Enter barcode of item returned: "
        '
        'RentedCodeTextBox
        '
        Me.RentedCodeTextBox.Location = New System.Drawing.Point(289, 47)
        Me.RentedCodeTextBox.Name = "RentedCodeTextBox"
        Me.RentedCodeTextBox.Size = New System.Drawing.Size(174, 20)
        Me.RentedCodeTextBox.TabIndex = 3
        '
        'RentedCodeLabel
        '
        Me.RentedCodeLabel.AutoSize = True
        Me.RentedCodeLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.RentedCodeLabel.Location = New System.Drawing.Point(36, 47)
        Me.RentedCodeLabel.Name = "RentedCodeLabel"
        Me.RentedCodeLabel.Size = New System.Drawing.Size(247, 20)
        Me.RentedCodeLabel.TabIndex = 2
        Me.RentedCodeLabel.Text = "Enter barcode of item rented out: "
        '
        'BuyingTab
        '
        Me.BuyingTab.BackColor = System.Drawing.Color.DarkGray
        Me.BuyingTab.Controls.Add(Me.NewItemButton)
        Me.BuyingTab.Controls.Add(Me.RentalSaleTextBox)
        Me.BuyingTab.Controls.Add(Me.RentalSaleLabel)
        Me.BuyingTab.Controls.Add(Me.PriceTextBox)
        Me.BuyingTab.Controls.Add(Me.PriceLabel)
        Me.BuyingTab.Controls.Add(Me.NewItemLabel)
        Me.BuyingTab.Controls.Add(Me.SizeTextBox)
        Me.BuyingTab.Controls.Add(Me.SizeLabel)
        Me.BuyingTab.Controls.Add(Me.TypeTextBox)
        Me.BuyingTab.Controls.Add(Me.TypeLabel)
        Me.BuyingTab.Controls.Add(Me.BrandTextBox)
        Me.BuyingTab.Controls.Add(Me.BrandLabel)
        Me.BuyingTab.Location = New System.Drawing.Point(4, 22)
        Me.BuyingTab.Name = "BuyingTab"
        Me.BuyingTab.Padding = New System.Windows.Forms.Padding(3)
        Me.BuyingTab.Size = New System.Drawing.Size(503, 354)
        Me.BuyingTab.TabIndex = 3
        Me.BuyingTab.Text = "Buying"
        '
        'NewItemButton
        '
        Me.NewItemButton.Location = New System.Drawing.Point(288, 16)
        Me.NewItemButton.Name = "NewItemButton"
        Me.NewItemButton.Size = New System.Drawing.Size(115, 26)
        Me.NewItemButton.TabIndex = 15
        Me.NewItemButton.Text = "Create Item"
        Me.NewItemButton.UseVisualStyleBackColor = True
        '
        'RentalSaleTextBox
        '
        Me.RentalSaleTextBox.Location = New System.Drawing.Point(260, 301)
        Me.RentalSaleTextBox.Name = "RentalSaleTextBox"
        Me.RentalSaleTextBox.Size = New System.Drawing.Size(174, 20)
        Me.RentalSaleTextBox.TabIndex = 14
        '
        'RentalSaleLabel
        '
        Me.RentalSaleLabel.AutoSize = True
        Me.RentalSaleLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.RentalSaleLabel.Location = New System.Drawing.Point(8, 301)
        Me.RentalSaleLabel.Name = "RentalSaleLabel"
        Me.RentalSaleLabel.Size = New System.Drawing.Size(246, 20)
        Me.RentalSaleLabel.TabIndex = 13
        Me.RentalSaleLabel.Text = "Enter Rental or Sale (Ex: R or S): "
        '
        'PriceTextBox
        '
        Me.PriceTextBox.Location = New System.Drawing.Point(189, 241)
        Me.PriceTextBox.Name = "PriceTextBox"
        Me.PriceTextBox.Size = New System.Drawing.Size(174, 20)
        Me.PriceTextBox.TabIndex = 12
        '
        'PriceLabel
        '
        Me.PriceLabel.AutoSize = True
        Me.PriceLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.PriceLabel.Location = New System.Drawing.Point(8, 241)
        Me.PriceLabel.Name = "PriceLabel"
        Me.PriceLabel.Size = New System.Drawing.Size(175, 20)
        Me.PriceLabel.TabIndex = 11
        Me.PriceLabel.Text = "Enter Price (Ex: 35.00): "
        '
        'NewItemLabel
        '
        Me.NewItemLabel.AutoSize = True
        Me.NewItemLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 16.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.NewItemLabel.Location = New System.Drawing.Point(131, 16)
        Me.NewItemLabel.Name = "NewItemLabel"
        Me.NewItemLabel.Size = New System.Drawing.Size(105, 26)
        Me.NewItemLabel.TabIndex = 10
        Me.NewItemLabel.Text = "New Item"
        '
        'SizeTextBox
        '
        Me.SizeTextBox.Location = New System.Drawing.Point(255, 181)
        Me.SizeTextBox.Name = "SizeTextBox"
        Me.SizeTextBox.Size = New System.Drawing.Size(174, 20)
        Me.SizeTextBox.TabIndex = 9
        '
        'SizeLabel
        '
        Me.SizeLabel.AutoSize = True
        Me.SizeLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.SizeLabel.Location = New System.Drawing.Point(8, 181)
        Me.SizeLabel.Name = "SizeLabel"
        Me.SizeLabel.Size = New System.Drawing.Size(241, 20)
        Me.SizeLabel.TabIndex = 8
        Me.SizeLabel.Text = "Enter Size (EX: 152 or M or 7.5): "
        '
        'TypeTextBox
        '
        Me.TypeTextBox.Location = New System.Drawing.Point(229, 125)
        Me.TypeTextBox.Name = "TypeTextBox"
        Me.TypeTextBox.Size = New System.Drawing.Size(174, 20)
        Me.TypeTextBox.TabIndex = 7
        '
        'TypeLabel
        '
        Me.TypeLabel.AutoSize = True
        Me.TypeLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.TypeLabel.Location = New System.Drawing.Point(8, 125)
        Me.TypeLabel.Name = "TypeLabel"
        Me.TypeLabel.Size = New System.Drawing.Size(215, 20)
        Me.TypeLabel.TabIndex = 6
        Me.TypeLabel.Text = "Enter Type (Ex: Snowboard): "
        '
        'BrandTextBox
        '
        Me.BrandTextBox.Location = New System.Drawing.Point(176, 67)
        Me.BrandTextBox.Name = "BrandTextBox"
        Me.BrandTextBox.Size = New System.Drawing.Size(174, 20)
        Me.BrandTextBox.TabIndex = 5
        '
        'BrandLabel
        '
        Me.BrandLabel.AutoSize = True
        Me.BrandLabel.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.BrandLabel.Location = New System.Drawing.Point(8, 67)
        Me.BrandLabel.Name = "BrandLabel"
        Me.BrandLabel.Size = New System.Drawing.Size(162, 20)
        Me.BrandLabel.TabIndex = 4
        Me.BrandLabel.Text = "Enter Brand (Ex: K2): "
        '
        'ClearButton
        '
        Me.ClearButton.Location = New System.Drawing.Point(385, 81)
        Me.ClearButton.Name = "ClearButton"
        Me.ClearButton.Size = New System.Drawing.Size(101, 22)
        Me.ClearButton.TabIndex = 6
        Me.ClearButton.Text = "Clear"
        Me.ClearButton.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(523, 388)
        Me.Controls.Add(Me.TabControl1)
        Me.Name = "Form1"
        Me.Text = "Inventory"
        Me.TabControl1.ResumeLayout(False)
        Me.SalesTab.ResumeLayout(False)
        Me.SalesTab.PerformLayout()
        Me.SearchTab.ResumeLayout(False)
        Me.SearchTab.PerformLayout()
        Me.RentalsTab.ResumeLayout(False)
        Me.RentalsTab.PerformLayout()
        Me.BuyingTab.ResumeLayout(False)
        Me.BuyingTab.PerformLayout()
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents TabControl1 As System.Windows.Forms.TabControl
    Friend WithEvents SalesTab As System.Windows.Forms.TabPage
    Friend WithEvents SearchTab As System.Windows.Forms.TabPage
    Friend WithEvents RentalsTab As System.Windows.Forms.TabPage
    Friend WithEvents SalesCodeLabel As System.Windows.Forms.Label
    Friend WithEvents BuyingTab As System.Windows.Forms.TabPage
    Friend WithEvents SalesCodeTextBox As System.Windows.Forms.TextBox
    Friend WithEvents FlawedCodeTextBox As System.Windows.Forms.TextBox
    Friend WithEvents FlawedCodeLabel As System.Windows.Forms.Label
    Friend WithEvents FindByLabel As System.Windows.Forms.Label
    Friend WithEvents FindByComboBox As System.Windows.Forms.ComboBox
    Friend WithEvents SearchResultsListBox As System.Windows.Forms.ListBox
    Friend WithEvents ReturnedCodeTextBox As System.Windows.Forms.TextBox
    Friend WithEvents ReturnedCodeLabel As System.Windows.Forms.Label
    Friend WithEvents RentedCodeTextBox As System.Windows.Forms.TextBox
    Friend WithEvents RentedCodeLabel As System.Windows.Forms.Label
    Friend WithEvents NewItemLabel As System.Windows.Forms.Label
    Friend WithEvents SizeTextBox As System.Windows.Forms.TextBox
    Friend WithEvents SizeLabel As System.Windows.Forms.Label
    Friend WithEvents TypeTextBox As System.Windows.Forms.TextBox
    Friend WithEvents TypeLabel As System.Windows.Forms.Label
    Friend WithEvents BrandTextBox As System.Windows.Forms.TextBox
    Friend WithEvents BrandLabel As System.Windows.Forms.Label
    Friend WithEvents RentalSaleTextBox As System.Windows.Forms.TextBox
    Friend WithEvents RentalSaleLabel As System.Windows.Forms.Label
    Friend WithEvents PriceTextBox As System.Windows.Forms.TextBox
    Friend WithEvents PriceLabel As System.Windows.Forms.Label
    Friend WithEvents ReturnFlawedButton As System.Windows.Forms.Button
    Friend WithEvents SoldButton As System.Windows.Forms.Button
    Friend WithEvents ReturnButton As System.Windows.Forms.Button
    Friend WithEvents RentedButton As System.Windows.Forms.Button
    Friend WithEvents NewItemButton As System.Windows.Forms.Button
    Friend WithEvents SearchTextBox As System.Windows.Forms.TextBox
    Friend WithEvents ReferenceWordLabel As System.Windows.Forms.Label
    Friend WithEvents SearchButton As System.Windows.Forms.Button
    Friend WithEvents ClearButton As System.Windows.Forms.Button

End Class
