Public Class Form1
    Private Sub SoldButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles SoldButton.Click
        SalesCodeTextBox.Text = ""
        MsgBox("Removed from inventory")
    End Sub

    Private Sub ReturnFlawedButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ReturnFlawedButton.Click
        FlawedCodeTextBox.Text = ""
        MsgBox("Removed from inventory")
    End Sub

    Private Sub SearchButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles SearchButton.Click
        Dim FindBy As String

        FindBy = FindByComboBox.SelectedItem

        Select Case FindBy

            Case "Barcode (Ex: 00000000)"
                SearchResultsListBox.Items.Add("Brand: Burton")
                SearchResultsListBox.Items.Add("Type: Bindings")
                SearchResultsListBox.Items.Add("Barcode: " + SearchTextBox.Text)
                SearchResultsListBox.Items.Add("Size: M")
                SearchResultsListBox.Items.Add("Price: 59.99")
                SearchResultsListBox.Items.Add("Rental or Sale: S")
            Case "Brand (Ex: K2)"
                SearchResultsListBox.Items.Add("Brand: " + SearchTextBox.Text)
                SearchResultsListBox.Items.Add("Type: Snowboard")
                SearchResultsListBox.Items.Add("Barcode: 12121212")
                SearchResultsListBox.Items.Add("Size: 130")
                SearchResultsListBox.Items.Add("Price: 210.00")
                SearchResultsListBox.Items.Add("Rental or Sale: S")
            Case "Type (Ex: Snowboard)"
                SearchResultsListBox.Items.Add("Brand: Atomic")
                SearchResultsListBox.Items.Add("Type: " + SearchTextBox.Text)
                SearchResultsListBox.Items.Add("Barcode: 11111111")
                SearchResultsListBox.Items.Add("Size: 8.5")
                SearchResultsListBox.Items.Add("Price: 149.00")
                SearchResultsListBox.Items.Add("Rental or Sale: S")
            Case Else
                SearchResultsListBox.Items.Add("Please Select What to Find By")
        End Select

        SearchResultsListBox.Items.Add("--------------------------------")
    End Sub

    Private Sub RentedButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles RentedButton.Click
        RentedCodeTextBox.Text = ""
        MsgBox("Flagged in inventory")
    End Sub

    Private Sub ReturnButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ReturnButton.Click
        ReturnedCodeTextBox.Text = ""
        MsgBox("Flag removed in inventory")
    End Sub

    Private Sub NewItemButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles NewItemButton.Click
        BrandTextBox.Text = ""
        TypeTextBox.Text = ""
        SizeTextBox.Text = ""
        PriceTextBox.Text = ""
        RentalSaleTextBox.Text = ""
        MsgBox("Item added to inventory")
    End Sub

    Private Sub ClearButton_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ClearButton.Click
        SearchResultsListBox.Items.Clear()
    End Sub
End Class
