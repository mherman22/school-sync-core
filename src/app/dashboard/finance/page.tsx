import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"

export default function FinancePage() {
  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-black">Finance</h1>
      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">Record Payment</CardTitle>
          <CardDescription className="text-gray-600">Enter student payment details.</CardDescription>
        </CardHeader>
        <CardContent>
          <form className="space-y-4">
            <Input className="bg-white text-black border-gray-300" placeholder="Student Name" />
            <Input className="bg-white text-black border-gray-300" placeholder="Amount" type="number" />
            <Input className="bg-white text-black border-gray-300" placeholder="Payment For" />
            <Button className="bg-blue-600 text-white hover:bg-blue-700">Record Payment</Button>
          </form>
        </CardContent>
      </Card>

      <Card>
        <CardHeader>
          <CardTitle className="text-2xl text-black">Recent Transactions</CardTitle>
          <CardDescription className="text-gray-600">View recent financial transactions.</CardDescription>
        </CardHeader>
        <CardContent>
          <div className="space-y-4">
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">John Doe - Tuition Fee - $500</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">Details</Button>
            </div>
            <div className="flex justify-between items-center p-4 bg-gray-100 rounded-md">
              <span className="text-black font-medium">Jane Smith - Boarding Fee - $300</span>
              <Button variant="outline" className="text-blue-600 border-blue-600 hover:bg-blue-50">Details</Button>
            </div>
          </div>
        </CardContent>
      </Card>
    </div>
  )
}